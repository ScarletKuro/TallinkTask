const initialState = {
    rooms: [],
    currentRoom: {
        location: '',
        roomName: '',
        conferences: [],
        seats: 0,
    },
};

export default function roomReducer(state = initialState, {type, ...action}) {
    switch (type) {
        case 'GET_ROOMS':
            return {...state, rooms: action.result.data.content};
        case 'GET_ROOM':
            return {...state, currentRoom: action.result.data};
        case 'DELETE_CONFERENCE':
            const newConferences = state.currentRoom.conferences.filter(element => {
                return element.id !== action.conId;
            });
            return {...state, currentRoom: {...state.currentRoom, conferences: newConferences}};
        case 'DELETE_ROOM':
            const newRooms = state.rooms.filter(element => {
                return element.id !== action.roomId;
            });
            return {...state, rooms: newRooms};
        case 'ADD_ROOM':
            state.rooms.push(action.payload);
            return {...state};
        case 'ADD_CONFERENCE':
            state.currentRoom.conferences.push(action.payload);
            return {...state};
        default:
            return state;
    }
}
