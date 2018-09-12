import React, {Component} from 'react';
import {identity} from 'lodash';
import {connect} from 'react-redux';
import {Link} from 'react-router-dom';
import {singleRoom, changeModalStatus} from '../actions/pageactions';
import ComponentConferences from '../components/ComponentConferences';
import ComponentNavbar from '../components/ComponentNavbar';
import ModalConference from '../modal/ModalConference';

class ConferenceView extends Component {

    constructor(props) {
        super(props);
        const {dispatch} = props;
        const {params} = this.props.match;
        dispatch(singleRoom(params.id));
        dispatch(changeModalStatus(true));
    }

    handleNewConference() {
        const {dispatch} = this.props;
        dispatch(changeModalStatus(false));
    }

    render() {
        const {showModal} = this.props.modalReducer;
        const {roomName, location, conferences, seats, id} = this.props.roomReducer.currentRoom;

        const addNewConBtn = (
            <button
                className="btn btn-info btn-fill pull-right"
                onClick={event => this.handleNewConference(event)}>
                Create new conference
            </button>
        );

        const body = roomName !== undefined && roomName.length !== 0 ? (
            <div className="container custom-container">
                <div className="header">
                    <h1 className="title"><Link to={'/'}>{roomName}</Link></h1>
                    <h4 className="title">{location}</h4>
                </div>
                <ComponentConferences seats={seats} data={conferences} roomid={id}/>
                {addNewConBtn}
            </div>
        ) : (<h1>No data</h1>);
        const modal = showModal ?
            <ModalConference roomId={this.props.match.params.id}/> : '';
        return (
            <div>
                <ComponentNavbar/>
                {modal}
                {body}
            </div>
        );
    }
}

export default connect(identity)(ConferenceView);
