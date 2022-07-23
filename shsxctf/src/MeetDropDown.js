import { useState } from "react";
import MeetList from "./MeetList";
import useFetch from "./useFetch";
import useFetchTwo from "./useFetchTwo";



const MeetDropDown = (props) => {
    const url = 'https://www.shsxctf.com/api/result/meet';

    const {data, isPending, error} = useFetch(url);



    return (
        <div>   
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <MeetList meets={data} season={props.season}/> }
        </div>
    );
}
 
export default MeetDropDown;