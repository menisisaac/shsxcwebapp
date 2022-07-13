import ResultLines from "./ResultLines";


const ResultLineList = (props) => {
    const lines = props.lines;

    return (
        <div className='resultline-list'>
        {lines.map((result) => (
           <div>
            <h2>{result.name}</h2>
            <ResultLines eventId={result.eventId} raceId={result.id}/>
            </div>
        ))}
    </div>
    );
}
 
export default ResultLineList;