import MeetList from "./MeetList";
import useFetch from "./useFetch";


const MeetDropDown = (props) => {
    const url = 'http://192.168.1.16/api/result/meet';
    const {data, isPending, error} = useFetch(url);
    return (
        <div>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <MeetList meets={data}/> }
        </div>
    );
}
 
export default MeetDropDown;