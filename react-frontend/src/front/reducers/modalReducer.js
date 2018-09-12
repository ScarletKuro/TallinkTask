const initialState = {
    showModal: false,
}

export default function modalReducer(state = initialState, {type, ...action}) {
    switch (type) {
        case 'MODAL_CHANGE':
            return {...state, showModal: !action.currentStatus};
        default:
            return state;
    }
}
