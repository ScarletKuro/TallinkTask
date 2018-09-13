import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import {compose, createStore, applyMiddleware} from 'redux';
import {Route, Switch, BrowserRouter} from 'react-router-dom';
import {combineReducers} from 'redux';
import thunk from 'redux-thunk';
import roomReducer from './reducers/roomReducer';
import conferenceReducer from './reducers/conferenceReducer';
import modalReducer from './reducers/modalReducer';
import RoomView from './views/RoomView';
import ConferenceView from './views/ConferenceView';
import ParticipantView from './views/ParticipantView';

import './style/light-bootstrap-dashboard.scss';

const rootReducer = combineReducers({
  roomReducer,
  conferenceReducer,
  modalReducer,
});

function main() {

  const target = document.getElementById('root');
  const devTools = window.devToolsExtension ? window.devToolsExtension() : (variable) => variable;
  const finalCreateStore = compose(applyMiddleware(thunk), devTools)(createStore);
  const store = finalCreateStore(rootReducer);
  render(
    <Provider store={store}>
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={RoomView}/>
          <Route exact path="/room/:id" component={ConferenceView}/>
          <Route exact path="/room/:roomId/conference/:conId" component={ParticipantView}/>
        </Switch>
      </BrowserRouter>
    </Provider>, target,
  );
}

main();
