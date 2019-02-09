import request from '../utils/axios.request';

const login = async (data) => {
  return request.post({
    url: '/auth/login',
    data,
  });
};

const register = async (data) => request.post({
  url: '/api/auth/register',
  data,
});

const refresh = async () => request.get({
  url: '/api/auth/refresh',
});

const logout = async () => request.post({});

export {
  login,
  register,
  refresh,
  logout,
};
