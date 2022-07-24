
const EventList = (props) => {
    const events = props.schedule;


    return (
        <div className='event-list'>
            <h2 style={{color:'red', textDecoration:'underline'}}>Schedule</h2>
            {events.map((event) => (
               <div className='event-info' key={event.id}>
                <h2>{event.name}</h2>
                <p>Location: {event.location} Date: {event.date} Time: {event.time}</p>
                </div>
            ))}
        </div>
    );
}
 
export default EventList;