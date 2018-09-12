import {
    getConferenceById,
    deleteParticipantById,
    addParticipant,
    getRoomById,
    getAllRooms,
    deleteConferenceById,
    addConference,
    addRoom,
    deleteRoomById,
} from '../api/apiroute';

export const GET_CONFERENCE = 'GET_CONFERENCE';
export const GET_ROOM = 'GET_ROOM';
export const GET_ROOMS = 'GET_ROOMS';
export const DELETE_PARTICIPANT = 'DELETE_PARTICIPANT';
export const DELETE_CONFERENCE = 'DELETE_CONFERENCE';
export const DELETE_ROOM = 'DELETE_ROOM';
export const ADD_PARTICIPANT = 'ADD_PARTICIPANT';
export const ADD_ROOM = 'ADD_ROOM';
export const ADD_CONFERENCE = 'ADD_CONFERENCE';
export const MODAL_CHANGE = 'MODAL_CHANGE';

export function changeModalStatus(currentStatus) {
    return dispatch => dispatch({type: MODAL_CHANGE, currentStatus});
}

function conference(result, type) {
    return {type, result};
}

function room(result, type) {
    return {type, result};
}

export function singleConference(roomId, conId) {
    return dispatch => {
        getConferenceById(roomId, conId)
            .then(res => {
                dispatch(conference(res, GET_CONFERENCE));
            });
    };
}

export function deleteParticipantInConference(id) {
    deleteParticipantById(id);
    return dispatch => dispatch({type: DELETE_PARTICIPANT, id});
}

export function addParticipantInConference(data, roomId, conId) {
    return dispatch => {
        addParticipant(data, conId).then(res => {
            dispatch({type: ADD_PARTICIPANT, data});
        }).then(res => {
            getConferenceById(roomId, conId)
                .then(res => {
                    dispatch(conference(res, GET_CONFERENCE));
                });
        });
    };
}


export function singleRoom(id) {
    return dispatch => {
        getRoomById(id)
            .then(res => {
                dispatch(room(res, GET_ROOM));
            });
    };
}

export function allRooms() {
    return dispatch => {
        getAllRooms()
            .then(res => {
                dispatch(room(res, GET_ROOMS));
            });
    };
}

export function addRoomToPage(payload) {
    return dispatch => {
        addRoom(payload).then(res => {
            dispatch({type: ADD_ROOM, payload});
        }).then(res => {
            getAllRooms().then(res => {
                dispatch(room(res, GET_ROOMS));
            });
        });
    };
}

export function addConferenceToRoom(payload, roomId) {
    return dispatch => {
        addConference(payload, roomId).then(res => {
            dispatch({type: ADD_CONFERENCE, payload});
        }).then(res => {
            getRoomById(roomId)
                .then(res => {
                    dispatch(room(res, GET_ROOM));
                });
        });
    };
}

export function deleteConferenceFromRoom(roomId, conId) {
    deleteConferenceById(roomId, conId);
    return dispatch => dispatch({type: DELETE_CONFERENCE, conId});
}

export function deleteRoom(roomId) {
    deleteRoomById(roomId);
    return dispatch => dispatch({type: DELETE_ROOM, roomId});
}
