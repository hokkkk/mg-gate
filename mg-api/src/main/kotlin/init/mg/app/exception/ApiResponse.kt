package init.mg.app.exception

class ApiResponse {
    lateinit var error: ApiError

    constructor( error : ApiError) {
        this.error = error;
    }
}