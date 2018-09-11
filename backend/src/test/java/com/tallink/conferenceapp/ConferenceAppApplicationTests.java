package com.tallink.conferenceapp;

import com.tallink.conferenceapp.dto.ParticipantDTO;
import com.tallink.conferenceapp.model.ConferenceEntity;
import com.tallink.conferenceapp.model.ConferenceRoomEntity;
import com.tallink.conferenceapp.model.ParticipantEntity;
import com.tallink.conferenceapp.repository.ConferenceRepository;
import com.tallink.conferenceapp.repository.ConferenceRoomRepository;
import com.tallink.conferenceapp.repository.ParticipantRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConferenceAppApplicationTests {

	@Autowired
	ParticipantRepository participantRepository;

	@Autowired
	ConferenceRepository conferenceRepository;

	@Autowired
	ConferenceRoomRepository conferenceRoomRepository;

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}

	public <T> T RandomItemInList(List<T> list){
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}

	@Test
	public void testAllParticipantStatus(){
		given().port(port).when().get("/api/public/participant/").then().assertThat().contentType(ContentType.JSON);
	}

	@Test
	public void testParticipantIdStatus(){
		ParticipantEntity participantEntity = RandomItemInList(this.participantRepository.findAll());
		given().port(port).when().get("/api/public/participant/" + participantEntity.id).then().assertThat().contentType(ContentType.JSON);
	}

	@Test
	public void testAllRoomsStatus() throws Exception {
		given().port(port).when().get("/api/public/room/").then().assertThat().contentType(ContentType.JSON);
	}

	@Test
	public void testRoomIdStatus() throws Exception {
		ConferenceRoomEntity roomEntity = RandomItemInList(this.conferenceRoomRepository.findAll());
		given().port(port).when().get("/api/public/room/" + roomEntity.id).then().assertThat().contentType(ContentType.JSON);
	}

	@Test
	public void testConferenceStatus() throws Exception {
		ConferenceRoomEntity roomEntity = RandomItemInList(this.conferenceRoomRepository.findAll());
		given().port(port).when().get("/api/public/room/"+ roomEntity.id +"/conferences").then().assertThat().contentType(ContentType.JSON);
	}

	@Test
	public void testConferenceIdStatus() throws Exception {
		ConferenceEntity conferenceEntity = RandomItemInList(this.conferenceRepository.findAll());
		given().port(port).when().get("/api/public/room/"+ conferenceEntity.getConferenceRoom().id +"/conferences/" + conferenceEntity.id).then().assertThat().contentType(ContentType.JSON);
	}

	@Test
	public void testRemoveConferenceId(){
		int count = this.conferenceRepository.findAll().size();

		ConferenceEntity conferenceEntity = this.conferenceRepository.findOne(1L);
		given().port(port).when().delete("/api/public/room/"+ conferenceEntity.getConferenceRoom().id+"/conferences/" + conferenceEntity.id);
		int newcount = this.conferenceRepository.findAll().size();
		Assert.assertEquals(newcount, count-1);
	}

	@Test
	public void testParticipantIdRemove() throws Exception {
		int count = this.participantRepository.findAll().size();
		given().port(port).when().delete("/api/public/participant/1");
		int newcount =  this.participantRepository.findAll().size();
		Assert.assertEquals(newcount, count-1);
	}

	@Test
	public void testParticipantAdd(){
		JSONObject participant = new JSONObject();
		participant.put("participantName", "Jonathan Morales");
		participant.put("participantBirthDay", "1994-10-10");
		String jsonParticipant = participant.toJSONString();

		int count = this.participantRepository.findAll().size();
		given().port(port).when().contentType(ContentType.JSON)
				.body(jsonParticipant)
				.post("/api/public/participant/conference/1");
		int newcount = this.participantRepository.findAll().size();
		Assert.assertEquals(newcount, count+1);
	}

	@Test
	public void testDeleteRoomId(){
		int count = this.conferenceRoomRepository.findAll().size();

		given().port(port).when().delete("/api/public/room/1");
		int newcount =  this.conferenceRoomRepository.findAll().size();
		Assert.assertEquals(newcount, count-1);
	}
}
