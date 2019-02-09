import {
  AUTH_REFRESH_REQUEST,
  AUTH_REFRESH_FAILURE,
  AUTH_REFRESH_SUCCESS,
} from './constants';
import {
  login as authLogin,
} from '../../api';
import { setAuthority } from '../../utils/authority';
import { reloadAuthorized } from '../../utils/Authorized';

const authRefreshRequest = (payload) => {
  return {
    type: AUTH_REFRESH_REQUEST,
    isLoading: true,
    payload,
  };
};

const authRefreshFailure = (payload) => {
  return {
    type: AUTH_REFRESH_FAILURE,
    isLoading: false,
    payload,
  };
};

const authRefreshSuccess = (payload) => {
  return {
    type: AUTH_REFRESH_SUCCESS,
    isLoading: false,
    payload,
  };
};

export const login = (request) => {
  return async (dispatch) => {
    dispatch(authLoginRequest());
    try {
      const response = await authLogin(request);
      dispatch(authLoginSuccess(response.data.value));
      if (response.data.statusCode === 200) {
        setAuthority(response.data.value.roles);
        reloadAuthorized();
      }
    } catch (e) {
      dispatch(authLoginFailure());
    }
  };
}
