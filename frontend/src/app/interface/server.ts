import { Status } from "../enum/status.enum";

/**
 * This server interface includes the data of a server
 */


export interface Server {
    id: number;
    ipAddress: string;
    name: string;
    memory: string;
    type: string;
    imageurl: string;
    status: Status;
}