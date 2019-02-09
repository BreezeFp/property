import request from '../utils/axios.request';

const getUserProfile = async () => request.get({
  url: '/api/user',
});

export {
  getUserProfile,
};
