/* eslint jsx-a11y/no-noninteractive-element-interactions:0 */
import React, { PureComponent } from 'react';
import { Balloon, Icon, Nav } from '@alifd/next';
import IceImg from '@icedesign/img';
import Layout from '@icedesign/layout';
import cx from 'classnames';
import { Link, withRouter } from 'react-router-dom';
import { headerMenuConfig } from '../../../../menuConfig';
import Logo from '../Logo';

import './index.scss';

@withRouter
export default class Header extends PureComponent {
  handleSetting = () => {
    this.props.history.push('/account/setting');
  };
  render() {
    const { isMobile, className, style } = this.props;

    return (
      <Layout.Header
        className={cx('ice-design-layout-header', className)}
        style={{ ...style }}
      >
        <Logo />

        <div className="ice-design-layout-header-menu">
          {/* Header 菜单项 begin */}
          {headerMenuConfig && headerMenuConfig.length > 0 ? (
            <Nav direction="hoz" type="secondary" selectedKeys={[]}>
              {headerMenuConfig.map((nav, idx) => {
                const linkProps = {};
                if (nav.newWindow) {
                  linkProps.href = nav.path;
                  linkProps.target = '_blank';
                } else if (nav.external) {
                  linkProps.href = nav.path;
                } else {
                  linkProps.to = nav.path;
                }
                return (
                  <Nav.Item key={idx} icon={nav.icon ? nav.icon : null}>
                    {linkProps.to ? (
                      <Link {...linkProps}>{!isMobile ? nav.name : null}</Link>
                    ) : (
                      <a {...linkProps}>{!isMobile ? nav.name : null}</a>
                    )}
                  </Nav.Item>
                );
              })}
            </Nav>
          ) : null}
          {/* Header 菜单项 end */}

          {/* Header 右侧内容块 */}
          <Balloon
            trigger={
              <div className="ice-design-header-userpannel">
                <IceImg
                  height={40}
                  width={40}
                  src="https://img.alicdn.com/tfs/TB1L6tBXQyWBuNjy0FpXXassXXa-80-80.png"
                  className="user-avatar"
                />
                <div className="user-profile">
                  <span className="user-name">淘小宝</span>
                  <br />
                  <span className="user-department">技术部</span>
                </div>
                <Icon type="arrow-down" size="xxs" className="icon-down" />
              </div>
            }
            closable={false}
            className="user-profile-menu"
          >
            <ul>
              <li
                className="user-profile-menu-item"
                onClick={this.handleSetting}
              >
                <Icon type="set" size="small" />
                设置
              </li>
              <li
                className="user-profile-menu-item"
                onClick={this.props.handleLogout}
              >
                <Icon type="upload" size="small" />
                退出
              </li>
            </ul>
          </Balloon>
        </div>
      </Layout.Header>
    );
  }
}
