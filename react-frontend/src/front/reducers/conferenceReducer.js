const initialState = {
    conferenceName: '',
    conferenceDateTime: '',
    participants: [],
};


export default function conferenceReducer(state = initialState, {type, ...action}) {
    switch (type) {
        case 'GET_CONFERENCE':
            return {
                ...state,
                conferenceName: action.result.data.conferenceName,
                conferenceDateTime: action.result.data.conferenceDateTime,
                participants: action.result.data.participants,
            };
        case 'DELETE_PARTICIPANT':
            const newParticipants = state.participants.filter(element => {
                return element.id !== action.id;
            });
            return {...state, participants: newParticipants};
        case 'ADD_PARTICIPANT':
            state.participants.push(action.data);
            return {...state};
        default:
            return state;
    }
}
