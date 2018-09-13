import React from 'react';
import {Route, Switch, BrowserRouter} from 'react-router-dom';
import RoomView from './views/RoomView';
import ConferenceView from './views/ConferenceView';
import ParticipantView from './views/ParticipantView';

export default (
  <BrowserRouter>
    <Switch>
      <Route exact path="/" component={RoomView}/>
      <Route exact path="/room/:id" component={ConferenceView}/>
      <Route exact path="/room/:roomId/conference/:conId" component={ParticipantView}/>
    </Switch>
  </BrowserRouter>
);
