import React from 'react';
import {CardContainer, FishPhoto, CardInfo, CardTitle, CardDescription, Price, ShopNowBtn} from './CatalogCardItem.styled';

const CatalogCardItem = ({shoesPhoto, color, lengthShafl, priceInUAH}) => {
    return (
        <CardContainer>
            <FishPhoto src={shoesPhoto}/>
            <CardInfo>
                <CardTitle>Fish</CardTitle>
                <CardDescription> {color} ,length {lengthShafl}. </CardDescription>
                <Price>$ {priceInUAH}</Price>
                <ShopNowBtn>Shop now</ShopNowBtn>
            </CardInfo>
        </CardContainer>
    );
};

export default CatalogCardItem;