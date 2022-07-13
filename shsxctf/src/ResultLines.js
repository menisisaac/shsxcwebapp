import IndividualLineList from "./IndividualLineList";

import useFetch from "./useFetch";


const ResultLines = (props) => {
    const url = 'http://192.168.1.212:8080/race?eventId=' + props.eventId + '&raceId=' + props.raceId;
    const {data, isPending, error} = useFetch(url);
    return (
        <div>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <IndividualLineList results={data}/> }
        </div>
    );
}
 
export default ResultLines;