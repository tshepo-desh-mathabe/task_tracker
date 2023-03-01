import axios from 'axios';
import HTTP_CONST from '../../constants/api_constants.json';

const http = HTTP_CONST.httpRequestType;

export const httpRequest = async (requestType, url, requestBody) => {

    const headers = new Headers({});

    switch (requestType) {
        case http.GET:
            return await axios.get(url, headers)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.POST:
            return await axios.post(url, requestBody, headers)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.PUT:
            return await axios.put(url, requestBody, headers)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.DELETE:
            return await axios.delete(url, requestBody, headers)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });
        default:
            break;
    }
}
