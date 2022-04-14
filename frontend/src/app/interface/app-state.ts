import { DataState } from "../enum/data.state.enum";
/**
 * this appstate interface will help to comunicate the state of the application. the application will first load,
 *  if it is in loaded stata, the data with be collected from the backend to the frontend, but if there is an error,
 *  the app will be in the error state.
 */


export interface AppState<T> {
    dataState: DataState;
    appData?: T;
    error?: string;
}