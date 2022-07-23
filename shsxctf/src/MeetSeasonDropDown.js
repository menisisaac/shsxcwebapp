import { useState } from "react";
import useFetch from "./useFetch";
import MeetDropDown from "./MeetDropDown";

const MeetSeasonDropDown = () => {
    const url = 'https://www.shsxctf.com/api/result/season/outdoor';
    const [selectedSeason, setSeason] = useState('1');
    const {data, isPending, error} = useFetch(url);

    return (
        <div>
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <form>
                <select
                value = {selectedSeason}
                onChange={(e) => setSeason(e.target.value)}
                >
                    {data.map((season) => (
                    <option value={season.season}>{season.season}</option>
                ))}
                </select>
            </form> }
            <MeetDropDown season={selectedSeason}/>
        </div>
    );
}
 
export default MeetSeasonDropDown;