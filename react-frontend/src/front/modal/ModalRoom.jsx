import React, {Component} from 'react';
import {identity} from 'lodash';
import {connect} from 'react-redux';
import {addRoomToPage, changeModalStatus} from '../actions/pageactions';

class ModalRoom extends Component {

    constructor(props) {
        super(props);
        this.state = {
            error: '',
        };
    }

    isInputValid(name, location, seats) {
        return name.value.length > 0 && location.value.length > 0 && seats.value > 0 && seats.value <= 127;
    }

    handleCloseModal() {
        const {dispatch} = this.props;
        dispatch(changeModalStatus(true));
    }

    handleSaveRoom() {
        const {dispatch} = this.props;
        const {name, location, seats} = this.refs;
        if (this.isInputValid(name, location, seats)) {
            dispatch(addRoomToPage({
                roomName: name.value.trim(),
                location: location.value.trim(),
                seats: seats.value,
            }));
            this.handleCloseModal();
        } else {
            this.setState({
                error: (
                    <div className="alert alert-danger" role="alert">
                        <strong>Error</strong> Inputs are wrong.
                    </div>
                ),
            });
        }
    }

    render() {
        return (
            <div className="custom-modal">
                <div className="custom-modal-content">
                    <h1 className="modal-header">Add new participant</h1>
                    <input
                        id="name"
                        ref="name"
                        className="modal-input"
                        type="text"
                        placeholder="Room Name"/>
                    <input
                        id="location"
                        ref="location"
                        className="modal-input"
                        type="text"
                        placeholder="Location"/>
                    <input
                        id="seats"
                        ref="seats"
                        className="modal-input"
                        type="number"
                        placeholder="Seats"/>
                    {this.state.error}
                    <div className="btn-toolbar">
                        <button
                            onClick={event => this.handleSaveRoom(event)}
                            className="btn btn-info btn-fill">
                            Save
                        </button>
                        <button
                            onClick={event => this.handleCloseModal(event)}
                            className="btn btn-info btn-fill">
                            Cancel
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

export default connect(identity)(ModalRoom);
