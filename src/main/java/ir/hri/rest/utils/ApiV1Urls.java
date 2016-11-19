package ir.hri.rest.utils;

public class ApiV1Urls {
    public static final String ApiV1Root = "/v1";

    public static final class BaseInfo {
        public static final String BASE_INFO = ApiV1Root + "/baseinfo";

        public static final String PATH_CITIES = "/cities";
        public static final String PATH_CITIES_STATE_ID = "/cities/{stateId}";
        public static final String PATH_CITY_ID = "/city/{id}";
        public static final String PATH_CITY_NAME = "/city/{name}";
        public static final String PARAM_ID = "id";
        public static final String PARAM_NAME = "name";
        public static final String PARAM_STATE_ID = "stateId";

        public static final String STATES = "/states";
    }
}
