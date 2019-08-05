Feature: Profile checking

  Scenario Outline: search in view peofile
    Given in home page
    When user input the profile target <name>
    Then press search at button
    Then check box at the new webpage
    Examples:
    |name|
    |Nguyen Tuan Doan|
    |Ho Trung Doan|
    |William Ngan|
    |Tran Van Phu|
    |Vu Ngoc Mark|
    |Vu Tien Dang|
    |William Hiep|
    |Phan Dang Dan|
    |William Tuan|
    |Tran Van Dang|
    |Tran Van Phuong|
    |Vu Tien Phong|
    |Ho Trung An|
    |Nguyen Ngoc Dai|
    |Vu Ngoc Dang|
    |Ho Trung Son|
    |Vu Ngoc Gia Nham|
    |Dinh Tu Son|
    |Dong Trac Dang|
    |Bob Khanh Ngan|
    |Ngo Vu Hoan|
    |Nguyen Vu Phuong Thao|
    |Chu Kim Cuong|
    |William Thanh|
    |Vuong Trang Nghia|
    |Dinh Tu Hung Cuong|
    |Nguyen Ngoc Linh|
    |Do Van Dai|
    |Vu Ngoc Hoan|
    |Tran Van Maria|
    |Le Hoa Maria|
    |Le Hoa Phu|
    |Luu Kinh Doan|
    |Tran Van Vuong|
    |Ta Quoc Ngan|
    |Dang Thu Trang|
    |Ta Quoc Cong|
    |Hoang Dinh Hung Cuong|
    |Ngo Vu Hoa|
    |Phan Charles|
    |Tran Van Khanh|
    