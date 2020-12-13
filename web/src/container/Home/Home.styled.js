import styled from 'styled-components';

const fishing = require("./../../icons/fishing.png").default;

export const HomePage = styled.div`
    margin:0;
`;
export const Advertisment = styled.div`
    margin-top: 10px;
    padding-left: 200px;
    width:auto;
    height: 522px;
    background-image: url(${fishing});
    color: #FFFFFF;
`;

export const AdvertismentTitle = styled.h1`
    margin: 0;
    padding-top: 100px;
    width: 410px;
    font-size: 48px;
`;

export const AdvertismentText = styled.p`
    width: 410px;
    font-size: 20px;
    font-weight: lighter;
    background: #000000 70%;

`;

export const ShowMoreBtn = styled.button`
    :hover{
        color: rgba(0, 0, 0, 0.5);
        background: #FFFFFF;
        cursor: pointer;
    }
    
    margin-left: 200px;
    margin-bottom: 45px;
    background: rgba(0, 0, 0, 0.5);
    padding: 12px 30px;
    border: 2px solid transparent;
    border-radius: 16px;
    border-color: #FFFFFF;
    color: #FFFFFF;
    font-size: 20px;
    margin: 0;
`;

export const MostPopular = styled.div`
    background-color: #F6F6F6;
    align-items: center;

`;

export const MostPopularTitle = styled.div`
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 28px;
    font-weight: lighter;
    color: #5b5b5b;
`;

export const Cards = styled.div`
    display: flex;
    justify-content: space-evenly;
    align-items: center;
`;

export const Slider = styled.div`
    margin: 0 auto;
    padding: 30px 0;
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 290px;
`;

export const Dots = styled.div`
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 170px;
`;
export const Line = styled.div`
    display: flex;
    justify-content: space-between;
    width: 200px;
`;