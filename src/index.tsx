import { NativeModules } from 'react-native';

type WechatUtilType = {
  multiply(a: number, b: number): Promise<number>;
};

const { WechatUtil } = NativeModules;

export default WechatUtil as WechatUtilType;
