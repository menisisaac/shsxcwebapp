import EventList from "./EventList";
import useFetch from "./useFetch";

const Schedule = () => {
    const {data, isPending, error} = useFetch("http://192.168.1.16/api/schedule/schedule");
    return (
       <div className='schedule'>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <EventList schedule={data}/> }
       </div>
    );
}
 
export default Schedule;