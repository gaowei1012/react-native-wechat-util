export type WechatModuleProps = {
  WechatModule: WechatModuleInterface; // props
};

export interface WechatModuleInterface {
  registerApp: (options: string) => PromiseConstructor; // 注册微信appId
  isWxInstalled: () => boolean; // 是否安装微信客户端
}
