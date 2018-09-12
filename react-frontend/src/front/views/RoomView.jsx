import React, {Component} from 'react';
import ComponentRooms from '../components/ComponentRooms';
import {identity} from 'lodash';
import {connect} from 'react-redux';
import {changeModalStatus} from '../actions/pageactions';
import ComponentNavbar from '../components/ComponentNavbar';
import ModalRoom from '../modal/ModalRoom';

class RoomView extends Component {

    constructor(props) {
        super(props);
        const {dispatch} = props;
        dispatch(changeModalStatus(true));
    }

    handleNewRoom() {
        const {dispatch} = this.props;
        dispatch(changeModalStatus(false));
    }

    valid(element) {
        return element !== undefined;
    }

    render() {
        const {showModal} = this.props.modalReducer;
        const addNewRoomBtn = (
            <button
                className="btn btn-info btn-fill pull-right"
                onClick={event => this.handleNewRoom(event)}>
                Create new room
            </button>
        );
        const body = (
            <div className="container custom-container">
                <div className="header">
                    <h1 className="title">Room List</h1>
                </div>
                <div className="content table-responsive table-full-width">
                    <ComponentRooms/>
                    {addNewRoomBtn}
                </div>
            </div>
        );
        const modal = showModal ? <ModalRoom/> : '';
        return (
            <div>
                <ComponentNavbar/>
                {body}
                {modal}
            </div>
        );
    }
}

export default connect(identity)(RoomView);
