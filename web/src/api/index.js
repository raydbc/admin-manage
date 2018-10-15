import axios from 'axios';
import qs from 'qs';
import { Message } from 'element-ui';

// axios 配置
axios.defaults.baseURL = 'http://localhost:8035';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

// axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8';
axios.defaults.timeout = 30000;

//添加请求拦截器
axios.interceptors.request.use(
  config => Object.assign(config, {data: qs.stringify(config.data)}),
  error => Promise.reject(error)
);

//添加响应拦截器
axios.interceptors.response.use(res => {
    console.log('---net---->', res);
    if(res.status != 200){
        Message({message: `${res.data.message}`, type: 'error', showClose: true});
        return Promise.reject(res);
    }
    return Promise.resolve(res.data);
}, error => {
    Message({message: `网络错误${error}`, type: 'error', showClose: true});
    return Promise.reject(error);
});

export default axios;
