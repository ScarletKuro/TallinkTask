import React, {Component} from 'react';
import {identity} from 'lodash';
import {connect} from 'react-redux';
import {deleteParticipantInConference} from '../actions/pageactions';

class ComponentParticipants extends Component {

    handleDelete(event, id) {
        this.props.dispatch(deleteParticipantInConference(id));
    }

    render() {
        const {participants} = this.props.conferenceReducer;
        return (
            <table className="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Participant Name</th>
                    <th>Participant Birthdate</th>
                </tr>
                </thead>
                <tbody>
                {
                    participants.map((element, key) => (
                        <tr key={key + 1}>
                            <th>{element.id}</th>
                            <td>{element.participantName}</td>
                            <td>{new Intl.DateTimeFormat('en-GB', {
                                year: 'numeric',
                                month: 'long',
                                day: '2-digit',
                            }).format(element.participantBirthDay)}</td>
                            <td>
                                <button onClick={event => this.handleDelete(event, element.id)}
                                        className="btn btn-info btn-fill pull-right">Delete
                                </button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        );
    }
}

export default connect(identity)(ComponentParticipants);
