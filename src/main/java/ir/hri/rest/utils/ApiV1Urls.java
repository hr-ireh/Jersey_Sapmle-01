package ir.hri.rest.utils;

public class ApiV1Urls {
    public static final String ApiV1Root = "/v1";

    public static final class BaseInfoPath {
        public static final String BASE_INFO = ApiV1Root + "/baseinfo";

        public static final String PATH_CITIES = "/cities";
        public static final String PATH_CITIES_STATE_ID = "/cities/{stateId}";
        public static final String PATH_CITY_ID = "/city/{id}";
        public static final String PATH_STATES = "/states";
        public static final String PATH_STATE_ID = "/state/{id}";

        public static final String PARAM_ID = "id";
        public static final String PARAM_STATE_ID = "stateId";

    }

    public static final class UserManagementPath {
        public static final String USER_MANAGE = ApiV1Root + "/usermanage";

        public static final String PATH_USERS = "/users";
        public static final String PATH_USER_USERNAME = "/user/{username}";
        public static final String PATH_INSERT = "/insert";

        public static final String PARAM_USERNAME = "username";
    }

    public static final class SendAndReceiveFilePath {
        public static final String FILE = ApiV1Root + "/file";

        public static final String PATH_UPLOAD = "/upload";
        public static final String PATH_DOWNLOAD = "/download/{filename}";

        public static final String PARAM_FILE_NAME = "filename";
    }
}