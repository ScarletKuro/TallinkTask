## List of API routes

|Route  |Method  | Description|
|--|--|--|
| /api/public/room/ |GET  |List of all rooms  |
| /api/public/room/:roomId |GET  |Single room by id  |
| /api/public/room/:roomId/conferences |GET| List of all conferences of selected room |
| /api/public/room/:roomId/conferences/:conId |GET  | Single conference by id of selected room  |
| /api/public/room/ |POST | Add new room by id|
| /api/public/room/:roomId/conferences |POST  | Add new conference to the room |
| /api/public/room/:roomId |DELETE | Delete the room |
| /api/public/room/:roomId/conferences/:conId |DELETE| Delete the conference by id from room |
| /api/public/participant/ |GET| List of all participants |
| /api/public/participant/:participantId |GET| Single participant by id |
| /api/public/participant/:participantId |DELETE| Delete participant by id  |
| /api/public/participant/conference/:conId|POST| Add new participant to conference by id  |


