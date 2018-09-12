import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {identity} from 'lodash';
import {connect} from 'react-redux';
import {deleteConferenceFromRoom} from '../actions/pageactions';

class ComponentConferences extends Component {

    handleDelete(event, roomId, conId) {
        this.props.dispatch(deleteConferenceFromRoom(roomId, conId));
    }

    render() {
        const {data, seats, roomid} = this.props;
        return (
            <table className="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Conference Name</th>
                    <th>Conference Datetime</th>
                    <th>Seats Available</th>
                </tr>
                </thead>
                <tbody>
                {
                    data.map((element, key) => (
                        <tr key={key + 1}>
                            <th>{element.id}</th>
                            <td>{element.conferenceName}</td>
                            <td>{new Intl.DateTimeFormat('en-GB', {
                                year: 'numeric',
                                month: 'long',
                                day: '2-digit',
                                hour: '2-digit',
                                minute: '2-digit',
                                hour12: true,
                            }).format(element.conferenceDateTime)}</td>
                            <td>{element.participants.length + ' of ' + seats}</td>
                            <td><Link to={'/room/' + roomid + '/conference/' + element.id}>View</Link></td>
                            <td>
                                <button onClick={event => this.handleDelete(event, roomid, element.id)}
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

export default connect(identity)(ComponentConferences);
