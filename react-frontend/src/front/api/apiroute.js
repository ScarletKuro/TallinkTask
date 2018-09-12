import axios from 'axios';

export function getAllRooms() {
    return axios.get('/api/public/room/')
        .catch(err => {
            console.log(err);
        });
}

export function getRoomById(roomId) {
    return axios.get('/api/public/room/' + roomId)
        .catch(err => {
            console.log(err);
        });
}

export function deleteRoomById(roomId) {
    return axios.delete('/api/public/room/' + roomId)
        .catch(err => {
            console.log(err);
        });
}

export function getConferenceById(roomId, conId) {
    return axios.get('/api/public/room/' + roomId + '/conferences/' + conId)
        .catch(err => {
            console.log(err);
        });
}

export function deleteConferenceById(roomId, conId) {
    return axios.delete('/api/public/room/' + roomId + '/conferences/' + conId)
        .catch(err => {
            console.log(err);
        });
}

export function deleteParticipantById(id) {
    return axios.delete('/api/public/participant/' + id)
        .catch(err => {
            console.log(err);
        });
}

export function addRoom(payload) {
    return axios.post('/api/public/room/', {
        ...payload,
    })
        .catch(err => {
            console.log(err);
        });
}

export function addParticipant(payload, conId) {
    return axios.post('/api/public/participant/conference/' + conId, {
        ...payload,
    })
        .catch(err => {
            console.log(err);
        });
}

export function addConference(payload, roomId) {
    return axios.post('/api/public/room/' + roomId + '/conferences/', {
        ...payload,
    })
        .catch(err => {
            console.log(err);
        });
}
