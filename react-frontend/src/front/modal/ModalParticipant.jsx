import React, {Component} from 'react';
import {identity} from 'lodash';
import {connect} from 'react-redux';
import {changeModalStatus, addParticipantInConference} from '../actions/pageactions';
import DatePicker from 'react-datepicker';
import moment from 'moment';

class ModalParticipant extends Component {

    constructor(props) {
        super(props);
        this.state = {
            date: moment(),
            error: '',
        };
    }

    isInputValid(name) {
        return name.value.length > 0;
    }

    handleDateChange = (date) => {
        this.setState({date});
    }

    handleCloseModal() {
        const {dispatch} = this.props;
        dispatch(changeModalStatus(true));
    }

    handleSaveParticipant() {
        const {dispatch, conId, roomId} = this.props;
        const {name} = this.refs;
        if (this.isInputValid(name)) {
            dispatch(addParticipantInConference({
                participantName: name.value.trim(),
                participantBirthDay: this.state.date,
            }, roomId, conId));
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
                        placeholder="Name"/>
                    <DatePicker
                        maxDate={moment()}
                        className="modal-date"
                        onChange={this.handleDateChange}
                        dateFormat="YYYY-MM-DD"
                        selected={this.state.date}/>
                    {this.state.error}
                    <div className="btn-toolbar">
                        <button
                            onClick={event => this.handleSaveParticipant(event)}
                            className="btn btn-info btn-fill pull-right">
                            Save
                        </button>
                        <button
                            onClick={event => this.handleCloseModal(event)}
                            className="btn btn-info btn-fill pull-right">
                            Cancel
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

export default connect(identity)(ModalParticipant);
