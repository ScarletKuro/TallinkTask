import React, {Component} from 'react';
import {identity} from 'lodash';
import {connect} from 'react-redux';
import {Link} from 'react-router-dom';
import ComponentParticipants from '../components/ComponentParticipants';
import {singleConference, singleRoom, changeModalStatus} from '../actions/pageactions';
import ComponentNavbar from '../components/ComponentNavbar';
import ModalParticipant from '../modal/ModalParticipant';

class ParticipantView extends Component {

    constructor(props) {
        super(props);
        const {dispatch} = props;
        const { params } = this.props.match;
        dispatch(singleRoom(params.roomId));
        dispatch(singleConference(params.roomId, params.conId));
        dispatch(changeModalStatus(true));
    }

    handleNewParticipant() {
        const {dispatch} = this.props;
        dispatch(changeModalStatus(false));
    }

    valid(element) {
        return element !== undefined;
    }

    render() {
        const {showModal} = this.props.modalReducer;
        const {seats, id} = this.props.roomReducer.currentRoom;
        const {conferenceName, conferenceDateTime, participants} = this.props.conferenceReducer;

        const addNewConBtn = this.valid(participants) && participants.length >= seats ? '' : (
            <button
                className="btn btn-info btn-fill pull-right"
                onClick={event => this.handleNewParticipant(event)}>
                Create new participant
            </button>
        );

        const body = this.valid(conferenceName) && conferenceName.length !== 0 ? (
            <div className="container custom-container">
                <div className="header">
                    <h1 className="title"><Link to={'/room/' + id}>{conferenceName}</Link></h1>
                    <h4 className="title">{new Intl.DateTimeFormat('en-GB', {
                        year: 'numeric',
                        month: 'long',
                        day: '2-digit',
                    }).format(conferenceDateTime)}</h4>
                </div>
                <div className="content table-responsive table-full-width">
                    <ComponentParticipants/>
                    {addNewConBtn}
                </div>
            </div>
        ) : (<h1>No data</h1>);

        const modal = showModal ?
            <ModalParticipant
                roomId={this.props.match.params.roomId}
                conId={this.props.match.params.conId}/> : '';

        return (
            <div>
                <ComponentNavbar/>
                {modal}
                {body}
            </div>
        );
    }
}

export default connect(identity)(ParticipantView);
