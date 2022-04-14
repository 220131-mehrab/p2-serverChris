import { Server } from "./server";

/**
 * this CustomResponse interface reflects back to our response interface in the backend to get the following
 * 
 */

export interface CustomResponse {
    timeStamp: Date;
    statusCode: number;
    status: string;
    reason: string;
    message: string;
    developerMessage: String;
    data: { servers?: Server[], server?: Server}
}