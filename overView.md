# WeatherAPI playing around

Sequence futbol24 request 

´´´mermaid
graph TD;
    A[Start] --> B{already present in SouthEnd Method};
    B -- Yes --> C[use returned keyword];
    B -- No --> D[check in workProcessor v2 ];
    C --> E[Call f24];
    D --> E;
´´´
