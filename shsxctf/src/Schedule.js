import EventList from "./EventList";
import useFetch from "./useFetch";

const Schedule = () => {
    const {data, isPending, error} = useFetch("http://www.shsxctf.com/api/schedule/schedule");
    return (
       <div className='schedule'>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <EventList schedule={data}/> }
       </div>
    );
}
 
export default Schedule;