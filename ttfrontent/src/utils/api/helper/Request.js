import axios from 'axios';
import HTTP_CONST from '../../constants/api_constants.json';


export const httpRequest = async (requestType, url, requestBody) => {
    const http = HTTP_CONST.httpRequestType;
    const headers = new Headers({
        'Content-Type': 'application/json',
    });

    // if( getSecretToken() ) {
    //     headers.append('Authorization', 'Bearer ' + getSecretToken() )
    // }

    switch (requestType) {
        case http.get:
            return await axios.get(url, headers)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.post:
            return await axios.post(url, requestBody, headers)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.put:
            return await axios.put(url, requestBody, headers)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.delete:
            return await axios.delete(url, requestBody, headers)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });
        default:
            break;
    }
}

export function combinedPaths(prePath, postPath) {
    return `${HTTP_CONST.apiBaseUrl}${prePath}${postPath}`;
}
