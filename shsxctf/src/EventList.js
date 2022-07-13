
const EventList = (props) => {
    const events = props.schedule;


    return (
        <div className='event-list'>
            {events.map((event) => (
               <div className='event-info' key={event.id}>
                <h2>{event.name}</h2>
                <p>Location: {event.location} Date: {event.date}</p>
                </div>
            ))}
        </div>
    );
}
 
export default EventList;