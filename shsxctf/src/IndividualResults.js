import MeetDropDown from "./MeetDropDown";
import ResultLineList from "./ResultLineList";
import useFetch from "./useFetch";

const IndividualResults = (props) => {
    const {data, isPending, error} = useFetch("http://192.168.1.212:8080/meet/races?eventId=" + props.meetId);
    return (
        <div className='individualresults'>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <ResultLineList lines={data}/> }
        </div>
    );
}
 
export default IndividualResults;