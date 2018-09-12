import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {identity} from 'lodash';
import {connect} from 'react-redux';
import {allRooms, deleteRoom} from '../actions/pageactions';


class ComponentRooms extends Component {

    constructor(props) {
        super(props);
        props.dispatch(allRooms());
    }

    handleDelete(event, roomId, conId) {
        this.props.dispatch(deleteRoom(roomId));
    }

    render() {
        const {rooms} = this.props.roomReducer;
        return (
            <table className="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Room Name</th>
                    <th>Room Location</th>
                    <th>Max seats</th>
                </tr>
                </thead>
                <tbody>
                {
                    rooms.map((room, key) => (
                        <tr key={key + 1}>
                            <th>{room.id}</th>
                            <td>{room.roomName}</td>
                            <td>{room.location}</td>
                            <td>{room.seats}</td>
                            <td><Link to={'/room/' + room.id}>View</Link></td>
                            <td>
                                <button onClick={event => this.handleDelete(event, room.id)}
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

export default connect(identity)(ComponentRooms);
