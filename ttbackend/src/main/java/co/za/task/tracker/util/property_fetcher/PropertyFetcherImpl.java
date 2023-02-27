package co.za.task.tracker.util.property_fetcher;

import co.za.task.tracker.util.constants.AppConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Implementation for property retrieval operator
 * Here we get a property and insert it in a field
 */
@Component
public class PropertyFetcherImpl implements IPropertyFetcher<AppConstant> {

    @Value("${app.jwt.bearer-text}")
    private String bearer;
    @Value("${app.jwt.authorization-text}")
    private String authorization;
    @Value("${error.message.unauthorized}")
    private String unauthorizedMessage;
    @Value("${app.jwt.secret}")
    private String jwtSecret;
    @Value("${app.jwt.expiration-time}")
    private String jwtExpirationTime;
    @Value("${error.message.email-format}")
    private String badEmailFormat;
    @Value("${error.message.email-exists}")
    private String emailExists;
    @Value("${error.message.went-wrong}")
    private String wentWrongMessage;
    @Value("${error.message.no-data}")
    private String noData;
    @Value("${error.message.no-document}")
    private String noDocuments;
   @Value("${delete.success.message}")
    private String successDelete;
    @Value("${save.success.message}")
    private String saveSuccess;
    @Value("${error.message.user-sign-in}")
    private String badLoginCredentials;
    @Value("${http.describe.head}")
    private String httpHead;
    @Value("${http.describe.options}")
    private String httpOptions;
    @Value("${http.describe.get}")
    private String httpGet;
    @Value("${http.describe.post}")
    private String httpPost;
    @Value("${http.describe.put}")
    private String httpPut;
    @Value("${http.describe.patch}")
    private String httpPatch;
    @Value("${http.describe.delete}")
    private String httpDelete;
    @Value("${fe.base.domain}")
    private String feBaseDomain;


    @Override
    public String getProperty(AppConstant keyValue) {
        return switch (keyValue) {
            case BEAR -> bearer;
            case AUTHORIZATION -> authorization;
            case UNAUTHORIZED_MESSAGE -> unauthorizedMessage;
            case JWT_SECRET -> jwtSecret;
            case JWT_EXPIRATION_TIME -> jwtExpirationTime;
            case BAD_EMAIL_FORMAT -> badEmailFormat;
            case EMAIL_EXISTS -> emailExists;
            case WENT_WRONG_MESSAGE -> wentWrongMessage;
            case NO_DATA_MESSAGE -> noData;
            case NO_DOCUMENTS -> noDocuments;
            case SUCCESS_DELETE_MESSAGE -> successDelete;
            case SAVE_SUCCESS_MESSAGE -> saveSuccess;
            case BAD_LOGIN_CREDENTIALS -> badLoginCredentials;
            case HTTP_HEAD -> httpHead;
            case HTTP_OPTIONS -> httpOptions;
            case HTTP_GET -> httpGet;
            case HTTP_POST -> httpPost;
            case HTTP_PUT -> httpPut;
            case HTTP_PATCH -> httpPatch;
            case HTTP_DELETE -> httpDelete;
            case FE_BASE_DOMAIN -> feBaseDomain;
        };
    }
}