import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Status } from '../enum/status.enum';
import { CustomResponse } from '../interface/custom-responses';
import { Server } from '../interface/server';

/**
 * This ServerService class inject or connect to the backend to obtain the required data
 * This is a react way of connecting to the backend
 */

@Injectable({
  providedIn: 'root'
})
export class ServerService {
  
  private readonly apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  //getting the list of all servers

 servers$ = <Observable<CustomResponse>>
 this.http.get<CustomResponse>(`${this.apiUrl}/server/list`)
 .pipe(
   tap(console.log),
   catchError(this.handleError)
 );

  //retrieving the post mapping to save a new server to the database
 save$ = (server: Server) => <Observable<CustomResponse>>
 this.http.post<CustomResponse>(`${this.apiUrl}/server/save`, server)
 .pipe(
   tap(console.log),
   catchError(this.handleError)
 );

  //pinging a server by ipAddress
 ping$ = (ipAddress: string) => <Observable<CustomResponse>>
 this.http.get<CustomResponse>(`${this.apiUrl}/server/ping/${ipAddress}`)
 .pipe(
   tap(console.log),
   catchError(this.handleError)
 );
  //filtering the status of the server
 filter$ = (status: Status, response: CustomResponse) => <Observable<CustomResponse>>
 new Observable<CustomResponse>(
   suscriber => {
     console.log(response);
     suscriber.next(
       status === Status.ALL ? { ...response, message: `Servers filtered by ${status} status`} :
       {
         ...response,
         message: response.data.servers //I don't understand why this undefined error is occuring and the data is defined in the CustomResponse
          .filter(server => server.status === status).length > 0 ? `servers filtered by ${status === Status.SERVER_UP ? 'SERVER UP' : 'SERVER DOWN'} status`
          : `No servers of ${status} found`,
          data: {
            servers: response.data.servers
              ?.filter(server => server.status === status)
          }
       }
     );
     suscriber.complete();
   }
 )
 .pipe(
   tap(console.log),
   catchError(this.handleError)
 );

  //obtaining deleting functionality of a server by its id
 delete$ = (serverId: number) => <Observable<CustomResponse>>
 this.http.delete<CustomResponse>(`${this.apiUrl}/server/delete/${serverId}`)
 .pipe(
   tap(console.log),
   catchError(this.handleError)
 );

  //this is a error handler
  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(`An error occured - Error code: ${error.status}`);
  }
}
