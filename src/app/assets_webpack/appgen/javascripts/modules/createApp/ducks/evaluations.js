import { createSelector } from 'reselect'
import { List } from 'immutable'
import * as api from '../api'
import prefix from '../prefix'
import createAction from '../../../misc/createAction'
import moduleSelector from '../selector'
import { Evaluation } from '../models'
import {createPromiseStatusSelector} from "../../core/ducks/promises";

// Actions

export const GET_EVALUATIONS = prefix('GET_EVALUATIONS');
export const GET_EVALUATIONS_START = GET_EVALUATIONS + '_START';
export const GET_EVALUATIONS_ERROR = GET_EVALUATIONS + '_ERROR';
export const GET_EVALUATIONS_SUCCESS = GET_EVALUATIONS + '_SUCCESS';

export function getEvaluations(userPipelineDiscoveryId) {
  const promise = api.getEvaluations(userPipelineDiscoveryId);
  return createAction(prefix('GET_EVALUATIONS'), { promise });
}
// Reducer

const initialState = List();

export default function evaluationsReducer(state = initialState, action) {
  switch (action.type) {
    case GET_EVALUATIONS_SUCCESS:
      return state.mergeDeep(action.payload);

    default:
      return state;
  }
}

// Selectors

export const promiseSelector = createPromiseStatusSelector(GET_EVALUATIONS);

const dataSelector = createSelector(
  [moduleSelector], state => state.evaluations
);

export const evaluationsSelector = createSelector(
  [dataSelector], evaluations =>
    evaluations.map(evaluation => new Evaluation(evaluation))
);
