import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import {compose, createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import {combineReducers} from 'redux';
import roomReducer from './reducers/roomReducer';
import conferenceReducer from './reducers/conferenceReducer';
import modalReducer from './reducers/modalReducer';

import router from './router';
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
    <Provider store={store}>{router}</Provider>, target,
  );
}

main();
