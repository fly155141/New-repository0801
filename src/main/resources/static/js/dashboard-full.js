// ✅ 自製地圖用：捷運站座標表
const stationCoords = {
  "七張": { x: 562.1, y: 965.3 },
  "三和國中": { x: 263.2, y: 334.6 },
  "三民高中": { x: 182.9, y: 276.2 },
  "三重": { x: 227.3, y: 481.6 },
  "三重國小": { x: 296.9, y: 361.2 },
  "中山": { x: 398.5, y: 472.7 },
  "中山國中": { x: 659.3, y: 408.6 },
  "中山國小": { x: 489.7, y: 387.0 },
  "中正": { x: 394.9, y: 697.6 },
  "中正紀念堂": { x: 394.9, y: 697.6 },
  "丹鳳": { x: 40.2, y: 576.6 },
  "亞東醫院": { x: 147.7, y: 716.7 },
  "信義安和": { x: 702.2, y: 663.7 },
  "先嗇宮": { x: 194.0, y: 502.3 },
  "內湖": { x: 877.5, y: 139.6 },
  "公館": { x: 553.8, y: 811.9 },
  "六張犁": { x: 688.3, y: 783.2 },
  "劍南路": { x: 594.0, y: 139.6 },
  "劍潭": { x: 401.9, y: 324.5 },
  "動物園": { x: 947.3, y: 865.2 },
  "動物園內站": { x: 899.9, y: 938.9 },
  "動物園站": { x: 881.1, y: 899.9 },
  "北投": { x: 356.2, y: 64.5 },
  "北門": { x: 294.5, y: 491.7 },
  "南京三民": { x: 730.9, y: 469.6 },
  "南京復興": { x: 584.3, y: 469.6 },
  "南勢角": { x: 366.4, y: 972.4 },
  "南港": { x: 945.5, y: 377.6 },
  "南港展覽館": { x: 942.8, y: 446.0 },
  "南港軟體園區": { x: 945.5, y: 377.6 },
  "古亭": { x: 437.1, y: 736.2 },
  "台北": { x: 674.8, y: 457.6 },
  "台北 101/世貿": { x: 767.8, y: 711.8 },
  "台北小巨蛋": { x: 674.8, y: 457.6 },
  "台北橋": { x: 308.4, y: 442.3 },
  "台北車站": { x: 403.4, y: 525.1 },
  "台大醫院": { x: 386.0, y: 625.6 },
  "台電大樓": { x: 538.5, y: 772.9 },
  "唭哩岸": { x: 414.5, y: 135.4 },
  "善導寺": { x: 473.6, y: 581.6 },
  "國父": { x: 724.2, y: 585.5 },
  "國父紀念館": { x: 724.2, y: 585.5 },
  "圓山": { x: 402.0, y: 356.4 },
  "土城": { x: 134.4, y: 814.5 },
  "士林": { x: 401.7, y: 282.8 },
  "大坪林": { x: 560.8, y: 929.6 },
  "大安": { x: 570.3, y: 653.5 },
  "大安森林公園": { x: 570.3, y: 653.5 },
  "大橋頭": { x: 326.5, y: 385.5 },
  "大湖公園": { x: 900.4, y: 208.6 },
  "大直": { x: 604.2, y: 222.6 },
  "奇岩": { x: 383.3, y: 106.0 },
  "小南門": { x: 287.7, y: 655.6 },
  "小巨蛋": { x: 674.8, y: 457.6 },
  "小碧潭": { x: 452.4, y: 942.1 },
  "展覽館": { x: 942.8, y: 446.0 },
  "市政府": { x: 765.3, y: 585.7 },
  "府中": { x: 134.6, y: 671.6 },
  "後山埤": { x: 868.9, y: 585.6 },
  "徐匯中學": { x: 215.7, y: 304.1 },
  "復興崗": { x: 291.1, y: 99.1 },
  "忠孝復興": { x: 654.2, y: 539.6 },
  "忠孝敦化": { x: 671.7, y: 585.6 },
  "忠孝新生": { x: 559.8, y: 541.7 },
  "忠義": { x: 234.4, y: 99.2 },
  "指南宮站": { x: 900.6, y: 979.9 },
  "文德": { x: 808.3, y: 139.6 },
  "新北投": { x: 421.9, y: 18.1 },
  "新埔": { x: 211.2, y: 622.1 },
  "新店": { x: 493.2, y: 1045.0 },
  "新店區公所": { x: 574.2, y: 1007.6 },
  "新莊": { x: 108.2, y: 540.3 },
  "昆陽": { x: 933.9, y: 557.2 },
  "明德": { x: 401.6, y: 201.6 },
  "景安": { x: 340.2, y: 885.2 },
  "景美": { x: 553.7, y: 892.5 },
  "木柵": { x: 850.8, y: 848.2 },
  "東湖": { x: 958.0, y: 312.6 },
  "東門": { x: 497.4, y: 663.4 },
  "松山": { x: 792.8, y: 463.6 },
  "松山機場": { x: 676.6, y: 313.6 },
  "松江南京": { x: 485.9, y: 472.1 },
  "板橋": { x: 171.7, y: 647.1 },
  "森林公園": { x: 570.3, y: 653.5 },
  "民權西路": { x: 392.5, y: 384.8 },
  "永安市場": { x: 326.8, y: 834.2 },
  "永寧": { x: 134.4, y: 860.3 },
  "永春": { x: 814.6, y: 585.6 },
  "江子翠": { x: 205.9, y: 576.9 },
  "海山": { x: 134.6, y: 771.1 },
  "淡水": { x: 122.0, y: -36.3 },
  "港墘": { x: 735.3, y: 139.6 },
  "石牌": { x: 436.8, y: 167.3 },
  "科技大樓": { x: 586.0, y: 737.3 },
  "竹圍": { x: 206.3, y: 35.1 },
  "紀念堂": { x: 394.9, y: 697.6 },
  "紀念館": { x: 724.2, y: 585.5 },
  "紅樹林": { x: 213.0, y: -3.0 },
  "芝山": { x: 402.2, y: 241.2 },
  "菜寮": { x: 264.4, y: 464.6 },
  "萬芳社區": { x: 799.0, y: 848.2 },
  "萬芳醫院": { x: 732.9, y: 884.5 },
  "萬隆": { x: 554.0, y: 852.9 },
  "葫州": { x: 937.0, y: 256.6 },
  "蘆洲": { x: 106.1, y: 240.4 },
  "行天宮": { x: 492.5, y: 437.1 },
  "西湖": { x: 663.0, y: 139.6 },
  "西門": { x: 298.0, y: 537.7 },
  "象山": { x: 845.9, y: 659.2 },
  "貓空站": { x: 872.1, y: 1010.9 },
  "貓空纜車": { x: 783.3, y: 972.1 },
  "車站": { x: 403.4, y: 525.1 },
  "軟體園區": { x: 945.5, y: 377.6 },
  "輔大": { x: 75.2, y: 558.4 },
  "辛亥": { x: 761.8, y: 824.2 },
  "迴龍": { x: -9.8, y: 543.3 },
  "關渡": { x: 178.6, y: 99.0 },
  "雙連": { x: 401.3, y: 444.5 },
  "頂埔": { x: 106.6, y: 934.1 },
  "頂溪": { x: 390.7, y: 777.6 },
  "頭前庄": { x: 148.3, y: 520.6 },
  "麟光": { x: 761.8, y: 789.2 },
  "龍山寺": { x: 264.1, y: 571.4 },
};

// ✅ 全域變數
let currentPage = 0;
let totalPages = 1;
let sortField = 'id';
let sortOrder = 'asc';
let originalData = {}; // 編輯用暫存原始資料

// ✅ CSRF
const csrfToken = document.querySelector('meta[name="_csrf"]').content;
const csrfHeaderName = document.querySelector('meta[name="_csrf_header"]').content;
// ✅ 購物車初始化（localStorage）
const cart = JSON.parse(localStorage.getItem('cart')) || [];
updateCartUI(); // 預設同步畫面
// ✅ 顯示成功或錯誤訊息
function showMessage(message, isSuccess = true) {
    let messageArea = document.getElementById('messageArea');

    // ✅ 檢查插入點是否存在
    const main = document.getElementById('mainContent');
    if (!main) {
        console.warn("❗ 無法顯示訊息：找不到 #mainContent");
        return;
    }

    if (!messageArea) {
        messageArea = document.createElement('div');
        messageArea.id = 'messageArea';
        main.prepend(messageArea);
    }

    messageArea.innerHTML = `
        <div class="alert ${isSuccess ? 'alert-success' : 'alert-danger'} alert-dismissible fade show" role="alert">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    `;

    // ✅ 延遲關閉提示
    setTimeout(() => {
        const alertBox = document.querySelector('#messageArea .alert');
        if (alertBox) {
            alertBox.classList.remove('show');
            alertBox.classList.add('hide');
        }
    }, 3000);
}


function loadContent(section) {
    const main = document.getElementById('mainContent');
    const urlMap = {
        'price': '/fragment/price',
        'map': '/fragment/map',
        'shop': '/fragment/shop',
        'welcome': '/fragment/welcome',
		'orders': '/fragment/orders'
    };
    const baseUrl = urlMap[section];
    if (!baseUrl) return;

    const lang = new URL(window.location.href).searchParams.get("lang");
    const fullUrl = lang ? `${baseUrl}?lang=${lang}` : baseUrl;

    fetch(fullUrl)
        .then(res => res.text())
        .then(html => {
            if (html.includes('id="loginForm"')) {
                window.location.href = '/index?timeout=true';
                return;
            }

            // ✅ 確保 messageArea 不會被覆蓋掉
            main.innerHTML = `
                <div id="messageArea" class="mb-3"></div>
                <div id="contentArea">${html}</div>
            `;

            // ✅ 事件綁定
            if (typeof bindAllEventHandlers === 'function') bindAllEventHandlers();
            if (typeof bindTooltipHandlers === 'function') bindTooltipHandlers();

            // ✅ 根據區塊載入語系
            if (['price', 'map', 'shop'].includes(section)) {
                fetch('/api/i18n')
                    .then(res => res.json())
                    .then(data => {
                        window.i18n = data;

                        if (section === 'price') {
                            if (typeof updateFileName === 'function') updateFileName();
                            if (typeof loadPricePage === 'function') {
                                setTimeout(() => loadPricePage(0), 0);
                            }
                            if (typeof refreshFavoriteButtonText === 'function') {
                                setTimeout(() => refreshFavoriteButtonText(), 100);
                            }
                        }

                        if (section === 'map') {
                            if (typeof loadMapFragment === 'function') loadMapFragment();
                        }

                        if (section === 'shop') {
                            if (typeof bindCardInputFormatter === 'function') bindCardInputFormatter();
							updateCartUI(); // ✅ 切換到 shop 頁面時重新載入購物車畫面
							}
                    })
                    .catch(err => {
                        console.warn("❌ 語系載入失敗：", err);

                        // fallback 還是執行主功能
                        if (section === 'map' && typeof loadMapFragment === 'function') {
                            loadMapFragment();
                        }
                    });
            } else if (section === 'welcome') {
                console.log("🟢 welcome 不需額外語系處理");
            }
        })
        .catch(err => {
            // ❗錯誤也要保留 messageArea
            main.innerHTML = `
                <div id="messageArea" class="mb-3"></div>
                <div class="text-danger">載入失敗：${err}</div>
            `;
        });
}
function navigateAndReload(section) {
  window.location.hash = section;
  loadContent(section);
}




// ✅ 綁定按鈕
function bindAllEventHandlers() {
    document.getElementById('previousPageBtn')?.addEventListener('click', previousPage);
    document.getElementById('nextPageBtn')?.addEventListener('click', nextPage);
}
function bindTooltipHandlers() {
    document.querySelectorAll('[data-tooltip]').forEach(input => {
        input.addEventListener('mouseover', function () {
            input._tooltipTimeout = setTimeout(() => {
                const tooltipText = input.getAttribute('data-tooltip');
                const tooltip = document.createElement('div');
                tooltip.className = 'tooltip-box';
                tooltip.innerText = tooltipText;
                document.body.appendChild(tooltip);

                const rect = input.getBoundingClientRect();
                tooltip.style.top = (rect.top + window.scrollY - 30) + 'px';
                tooltip.style.left = (rect.left + window.scrollX) + 'px';
                input._tooltip = tooltip;
            }, 500);
        });

        input.addEventListener('mouseout', function () {
            if (input._tooltipTimeout) clearTimeout(input._tooltipTimeout);
            if (input._tooltip) {
                input._tooltip.remove();
                input._tooltip = null;
            }
        });
    });
}



function loadPricePage(page = 0, callback = null) {
    const keyword = document.getElementById('searchKeyword')?.value.trim() || "";
    const lang = new URL(window.location.href).searchParams.get("lang") || "";
    const langParam = lang ? `&lang=${lang}` : "";

    // ✅ 查詢資料 API（支援關鍵字與排序）
    const url = keyword
        ? `/api/search?keyword=${encodeURIComponent(keyword)}&page=${page}&sortField=${sortField}&sortOrder=${sortOrder}${langParam}`
        : `/api/all?page=${page}&sortField=${sortField}&sortOrder=${sortOrder}${langParam}`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            currentPage = data.currentPage;
            totalPages = data.totalPages;

            // ✅ 更新網址（保留 lang 參數與 #price）
            const newUrl = `${window.location.pathname}?${lang ? `lang=${lang}` : ""}#price`;
            history.replaceState(null, "", newUrl);

            // ✅ 載入 Thymeleaf Fragment（資料表格）
            return fetch(`/fragment/price?page=${currentPage}&keyword=${encodeURIComponent(keyword)}&sortField=${sortField}&sortOrder=${sortOrder}${langParam}`);
        })
        .then(res => res.text())
        .then(html => {
            // ✅ Session timeout 處理
            if (html.includes('id="loginForm"')) {
                window.location.href = '/index?timeout=true';
                return;
            }

            // ✅ 顯示資料區塊
            const main = document.getElementById('mainContent');
            main.innerHTML = `<div id="messageArea" class="mb-3"></div>${html}`;

            // ✅ 綁定所有事件與樣式
            bindAllEventHandlers();
            updateSortIcons();
            markFavoriteButtons();
            bindTooltipHandlers();

            // ✅ 載入 i18n 語系 JSON（供 toggleFavorite 使用）
            return fetch('/api/i18n');
        })
        .then(res => res.json())
        .then(data => {
            window.i18n = data;

            // ✅ 更新所有收藏按鈕文字（根據語系）
            refreshFavoriteButtonText();
        })
        .then(() => {
            if (callback) callback();
        })
        .catch(err => {
            document.getElementById('mainContent').innerHTML =
                `<div class="text-danger">載入失敗：${err}</div>`;
        });
}



// ✅ 排序
function sortBy(field) {
    if (sortField === field) {
        sortOrder = (sortOrder === 'asc') ? 'desc' : 'asc';
    } else {
        sortField = field;
        sortOrder = 'asc';
    }
    loadPricePage(0);
}

// ✅ 更新排序箭頭
function updateSortIcons() {
    document.querySelectorAll('th[data-field]').forEach(th => {
        const field = th.getAttribute('data-field');
        th.innerHTML = th.getAttribute('data-title') +
            (field === sortField ? (sortOrder === 'asc' ? ' ▲' : ' ▼') : '');
    });
}

// ✅ 上下頁
function previousPage() {
    if (currentPage > 0) loadPricePage(currentPage - 1);
}
function nextPage() {
    if (currentPage + 1 < totalPages) loadPricePage(currentPage + 1);
}
function clearSearch() {
    document.getElementById('searchKeyword').value = '';
    loadPricePage(0);
}

// ✅ 新增資料
function addData() {
    clearAllHints();
    const payload = {
        startStation: document.getElementById('startStation').value.trim(),
        endStation: document.getElementById('endStation').value.trim(),
        fullPrice: document.getElementById('fullPrice').value.trim(),
        discountPriceNewTaipei: document.getElementById('discountPriceNewTaipei').value.trim(),
        discountPriceTaipei: document.getElementById('discountPriceTaipei').value.trim(),
        distance: document.getElementById('distance').value.trim()
    };
    if (!validateInput(payload, false)) return;

    fetch('/api/add', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', [csrfHeaderName]: csrfToken },
        body: JSON.stringify(payload)
    })
    .then(res => res.text())
    .then(msg => loadPricePage(0, () => showMessage(msg, true)))
    .catch(err => showMessage('新增失敗：' + err.message, false));
}

// ✅ 編輯資料
function editRow(id) {
    const row = document.getElementById(`row-${id}`);
    const cells = row.querySelectorAll('td');
    originalData[id] = [];
    for (let i = 1; i <= 6; i++) {
        originalData[id].push(cells[i].innerText);
        const inputType = (i === 1 || i === 2) ? 'text' : 'number';
        cells[i].innerHTML = `<input type="${inputType}" class="form-control" value="${originalData[id][i-1]}">`;
    }
    toggleEditButtons(id, true);
}

// ✅ 儲存資料
function saveRow(id) {
    clearAllHints();
    const row = document.getElementById(`row-${id}`);
    const inputs = row.querySelectorAll('input');
    const payload = {
        id: id,
        startStation: inputs[0].value.trim(),
        endStation: inputs[1].value.trim(),
        fullPrice: inputs[2].value.trim(),
        discountPriceNewTaipei: inputs[3].value.trim(),
        discountPriceTaipei: inputs[4].value.trim(),
        distance: inputs[5].value.trim()
    };
    if (!validateInput(payload, true, id)) return;

    fetch('/api/update', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', [csrfHeaderName]: csrfToken },
        body: JSON.stringify(payload)
    })
    .then(res => res.text())
    .then(msg => loadPricePage(currentPage, () => showMessage(msg, true)))
    .catch(err => showMessage('儲存失敗：' + err.message, false));
}
// ✅ 取消編輯
function cancelEdit(id) {
    const row = document.getElementById(`row-${id}`);
    const cells = row.querySelectorAll('td');
    for (let i = 1; i <= 6; i++) {
        cells[i].innerText = originalData[id][i - 1];
    }
    toggleEditButtons(id, false);
}
function toggleEditButtons(id, isEditing) {
    const editBtn = document.getElementById(`editBtn-${id}`);
    const saveBtn = document.getElementById(`saveBtn-${id}`);
    const cancelBtn = document.getElementById(`cancelBtn-${id}`);

    if (editBtn) editBtn.classList.toggle('d-none', isEditing);
    if (saveBtn) saveBtn.classList.toggle('d-none', !isEditing);
    if (cancelBtn) cancelBtn.classList.toggle('d-none', !isEditing);
}


// ✅ 刪除
function deleteData(id) {
    if (!confirm('確定要刪除這筆資料？')) return;
    fetch(`/api/delete/${id}`, {
        method: 'DELETE',
        headers: { [csrfHeaderName]: csrfToken }
    })
    .then(res => res.text())
    .then(msg => loadPricePage(currentPage, () => showMessage(msg, true)))
    .catch(err => showMessage('刪除失敗：' + err.message, false));
}

// ✅ 上傳CSV
function uploadCSV() {
    const fileInput = document.getElementById('csvFile');
    if (!fileInput) return showMessage("❌ 找不到檔案欄位", false);

    const file = fileInput.files[0];
    if (!file) return showMessage(window.i18n?.["file.none"] || "未選擇任何檔案", false);

    const formData = new FormData();
    formData.append('file', file);

    fetch('/api/upload', {
        method: 'POST',
        body: formData,
        headers: {
            [csrfHeaderName]: csrfToken
        }
    })
    .then(res => {
        if (!res.ok) throw new Error("上傳失敗");
        return res.text();
    })
    .then(msg => loadPricePage(0, () => showMessage(msg, true)))
    .catch(err => showMessage('❌ ' + err.message, false));
}

function updateFileName() {
    const fileInput = document.getElementById('csvFile');
    const fileNameLabel = document.getElementById('fileNameLabel');
    const file = fileInput?.files[0];

    fileNameLabel.textContent = file
        ? file.name
        : (window.i18n?.['file.none'] || fileNameLabel.getAttribute("data-default") || '未選擇任何檔案');
}


// ✅ 一鍵清除
function clearAll() {
    fetch('/api/deleteAll', {
        method: 'POST',
        headers: { [csrfHeaderName]: csrfToken }
    })
    .then(res => res.text())
    .then(msg => loadPricePage(0, () => showMessage(msg, true)))
    .catch(err => showMessage('清除失敗：' + err.message, false));

    // 🔄 重置檔案欄與顯示
    document.getElementById('csvFile').value = "";
    updateFileName();
}


// ✅ 驗證
// ✅ 驗證輸入欄位（使用語系 key）
function validateInput(data, isEdit, rowId = null) {
  const rules = [
    { value: data.startStation, regex: /^[\u4e00-\u9fa5]+$/, id: 'startStation', messageKey: 'form.start.required' },
    { value: data.endStation, regex: /^[\u4e00-\u9fa5]+$/, id: 'endStation', messageKey: 'form.end.required' },
    { value: data.fullPrice, regex: /^[1-9]\d*$/, id: 'fullPrice', messageKey: 'form.fullPrice.positive' },
    { value: data.discountPriceNewTaipei, regex: /^[1-9]\d*$/, id: 'discountPriceNewTaipei', messageKey: 'form.discount.ntpc.positive' },
    { value: data.discountPriceTaipei, regex: /^[1-9]\d*$/, id: 'discountPriceTaipei', messageKey: 'form.discount.taipei.positive' },
    { value: data.distance, regex: /^\d+(\.\d+)?$/, id: 'distance', messageKey: 'form.distance.positive' }
  ];

  let valid = true;
  rules.forEach((rule, i) => {
    let input;
    if (isEdit) {
      const row = document.getElementById(`row-${rowId}`);
      input = row.querySelectorAll('input')[i];
    } else {
      input = document.getElementById(rule.id);
    }

    clearHints(input);

    const fallback = document.querySelector(`#error-${input.id} span`);
    const message = window.i18n?.[rule.messageKey] || fallback?.innerText || rule.messageKey;

    if (!rule.regex.test(rule.value)) {
      showError(input, message);
      valid = false;
    } else {
      showSuccess(input);
    }
  });

  return valid;
}

function showError(input, messageKey) {
    clearHints(input);

    // 1️⃣ 嘗試從 window.i18n 中取語系對應訊息
    const i18nMessage = window.i18n?.[messageKey];

    // 2️⃣ 後備文字：從 HTML fallback <span> 讀出文字（通常由 Thymeleaf 提供）
    const fallbackSpan = document.querySelector(`#error-${input.id} span`);
    const fallbackText = fallbackSpan?.innerText;

    // 3️⃣ 最終決定顯示訊息：i18n > fallback > messageKey
    const resolvedMessage = i18nMessage || fallbackText || messageKey;

    // 4️⃣ 顯示錯誤訊息
    const error = document.createElement('div');
    error.className = 'text-danger small';
    error.innerText = resolvedMessage;

    input.parentElement.appendChild(error);
}



function showSuccess(input) {
    clearHints(input);

    const container = document.querySelector(`#error-${input.id}`);
    const successText = container?.getAttribute('data-success') || '✅ ';

    const success = document.createElement('div');
    success.className = 'text-success small';
    success.innerText = successText;

    input.parentElement.appendChild(success);
}



function clearHints(input) {
    input?.parentElement?.querySelectorAll('.text-danger, .text-success')?.forEach(e => e.remove());
}

function clearAllHints() {
    document.querySelectorAll('.text-danger, .text-success').forEach(e => e.remove());
}
// ✅ 一進 dashboard 頁面就自動載入歡迎畫面
document.addEventListener('DOMContentLoaded', () => {
    if (typeof loadContent === 'function') {
        loadContent('welcome');
    } else {
        console.warn("⚠️ loadContent 尚未定義，無法載入 welcome");
    }
});

// ✅ 收藏 / 取消收藏（使用紅心圖示）
function toggleFavorite(id) {
    const button = document.getElementById(`favoriteBtn-${id}`);
    if (!button) return;

    button.disabled = true;

    fetch(`/api/favorite/toggle/${id}`, {
        method: 'POST',
        headers: { [csrfHeaderName]: csrfToken }
    })
        .then(res => {
            if (!res.ok) throw new Error("favorite.error");
            return res.text(); // 可能為 "favorite.add" 或 "favorite.remove"
        })
        .then(key => {
            const isNowFavorited = key === "favorite.add";

            // ✅ 更新樣式
            button.classList.toggle("btn-danger", isNowFavorited);
            button.classList.toggle("btn-outline-danger", !isNowFavorited);

            // ✅ 更新文字
            button.innerText = isNowFavorited
                ? (window.i18n?.["favorite.saved"] || "❤️ 已收藏")
                : (window.i18n?.["favorite.label"] || "🤍 收藏");

            // ✅ 更新狀態屬性
            button.setAttribute("data-favorited", isNowFavorited);

            // ✅ 顯示訊息
            const msg = window.i18n?.[key] || key;
            showMessage(msg, true);
        })
        .catch(err => {
            const fallback = window.i18n?.["favorite.error"] || "收藏操作失敗";
            showMessage(fallback, false);
        })
        .finally(() => {
            button.disabled = false;
        });
}

// ✅ 標記所有已收藏的按鈕
function markFavoriteButtons() {
    fetch("/api/favorite/my")
        .then(res => res.json())
        .then(favorites => {
            const favoritedIds = favorites.map(f => f.id);

            document.querySelectorAll(".favorite-btn").forEach(btn => {
                const id = parseInt(btn.getAttribute("data-id"));
                const isFavorited = favoritedIds.includes(id);

                // ✅ 樣式
                btn.classList.toggle("btn-danger", isFavorited);
                btn.classList.toggle("btn-outline-danger", !isFavorited);

                // ✅ 文字
                btn.innerText = isFavorited
                    ? (window.i18n?.["favorite.saved"] || "❤️ 已收藏")
                    : (window.i18n?.["favorite.label"] || "🤍 收藏");

                // ✅ 狀態屬性
                btn.setAttribute("data-favorited", isFavorited);
            });
        });
}

function refreshFavoriteButtonText() {
    document.querySelectorAll(".favorite-btn").forEach(btn => {
        const isFavorited = btn.getAttribute("data-favorited") === "true";

        btn.innerText = isFavorited
            ? (window.i18n?.["favorite.saved"] || "❤️ 已收藏")
            : (window.i18n?.["favorite.label"] || "🤍 收藏");
    });
}


// ✅ 載入地圖區塊，並顯示收藏列表
function loadMapFragment() {
    fetch("/api/favorite/my")
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("favoriteList");
            const mapArea = document.getElementById("mapArea");
            if (!list || !mapArea) return;

            const i18n = window.i18n || {};
            list.innerHTML = "";

            // ✅ 尚無收藏資料
            if (data.length === 0) {
                list.innerHTML = `<li class='list-group-item'>${i18n["map.noFavorites"] || "尚無收藏資料"}</li>`;

                const note = document.getElementById("mapNote");
                if (note) note.remove();

                const message = document.createElement("p");
                message.id = "mapNote";
                message.className = "text-center mt-3";
                message.innerText = i18n["map.note"] || "請點選左方收藏項目以顯示對應路線";
                mapArea.appendChild(message);
                return;
            }

            // ✅ 有收藏資料：建立每個 li 與按鈕
            data.forEach(item => {
                const li = document.createElement("li");
                li.className = "list-group-item d-flex justify-content-between align-items-center";

                const btnText = i18n["map.showRoute"] || "顯示路線";

                const button = `
                    <button class="btn btn-sm btn-outline-primary show-route-btn"
                            onclick="handleShowRoute(this, '${item.startStation}', '${item.endStation}')"
                            data-default="顯示路線">
                        ${btnText}
                    </button>`;

                li.innerHTML = `
                    ${item.startStation} ➜ ${item.endStation}
                    ${button}
                `;
                list.appendChild(li);
            });

            // ✅ 下方提示
            const note = document.getElementById("mapNote");
            if (note) note.remove();

            const message = document.createElement("p");
            message.id = "mapNote";
            message.className = "text-center mt-3";
            message.innerText = i18n["map.note"] || "請點選左方收藏項目以顯示對應路線";
            mapArea.appendChild(message);
        });
}

function handleShowRoute(button, start, end) {
    if (!start || !end) return;
    showRoute(start, end); // 你原本已有的函式

    // ✅ 更新按鈕文字（語系切換後仍支援）
    const i18n = window.i18n || {};
    button.innerText = i18n["map.showRoute"] || button.getAttribute("data-default") || "顯示路線";
}





// ✅ Levenshtein 字距
function levenshteinDistance(a, b) {
    const matrix = Array.from({ length: a.length + 1 }, () => []);
    for (let i = 0; i <= a.length; i++) matrix[i][0] = i;
    for (let j = 0; j <= b.length; j++) matrix[0][j] = j;

    for (let i = 1; i <= a.length; i++) {
        for (let j = 1; j <= b.length; j++) {
            const cost = a[i - 1] === b[j - 1] ? 0 : 1;
            matrix[i][j] = Math.min(
                matrix[i - 1][j] + 1,     // 刪除
                matrix[i][j - 1] + 1,     // 插入
                matrix[i - 1][j - 1] + cost // 替換
            );
        }
    }
    return matrix[a.length][b.length];
}


// ✅ 根據 <text> 抓站名中心點
function getCoordsByStationName(name) {
    const svg = document.getElementById("mrtMap");
    if (!svg) return null;

    const text = Array.from(svg.querySelectorAll("text"))
        .find(el => el.textContent.trim() === name);

    if (!text) {
        console.warn(`❌ 找不到站名文字：${name}`);
        return null;
    }

    const box = text.getBBox();
    return {
        x: box.x + box.width / 2,
        y: box.y + box.height / 2
    };
}

// ✅ 顯示捷運路線圖上起訖站與連線
function showRoute(start, end) {
    const svg = document.getElementById("mrtMap");
    if (!svg) return;

    const layer = svg.querySelector("#layer1");
    if (!layer) return;

    const i18n = window.i18n || {};

    // ✅ 加入 glow 濾鏡（若尚未存在）
    if (!svg.querySelector("filter#glow")) {
        const defs = document.createElementNS("http://www.w3.org/2000/svg", "defs");
        defs.innerHTML = `
            <filter id="glow" x="-50%" y="-50%" width="200%" height="200%">
                <feGaussianBlur stdDeviation="3" result="blur"/>
                <feMerge>
                    <feMergeNode in="blur"/>
                    <feMergeNode in="blur"/>
                    <feMergeNode in="SourceGraphic"/>
                </feMerge>
            </filter>
        `;
        svg.prepend(defs);
    }

    // ✅ 清除舊標記與特效
    layer.querySelectorAll(".custom-circle, .custom-line, .custom-label").forEach(el => el.remove());
    clearStationEffects();
    applyStationEffect(start);
    applyStationEffect(end);

    // ✅ 起訖站相同，不畫線
    if (start === end) {
        const msg = `${i18n["map.sameStation"] || "此為同一站，無需顯示路線。"}（${start}）`;
        showMessage(msg, false); // ❌ 不再用 alert，改為訊息提示
        return;
    }

    let s1 = getCoordsByStationName(start);
    let s2 = getCoordsByStationName(end);

    if (!s1 || !s2) {
        const msg = i18n["map.coordMissing"] || `查無起訖站座標：${start} → ${end}`;
        showMessage(msg, false);
        return;
    }

    // ✅ 座標吸附最近線段
    s1 = adjustPointToNearestLine(s1);
    s2 = adjustPointToNearestLine(s2);

    [start, end].forEach((name, i) => {
        const pt = i === 0 ? s1 : s2;
        const label = document.createElementNS("http://www.w3.org/2000/svg", "text");
        label.setAttribute("x", pt.x);
        label.setAttribute("y", pt.y + 9);
        label.setAttribute("text-anchor", "middle");
        label.setAttribute("font-size", "16");
        label.setAttribute("fill", i === 0 ? "orange" : "blue");
        label.setAttribute("stroke", "#BDBDBD");
        label.setAttribute("stroke-width", "1.5");
        label.setAttribute("filter", "url(#glow)");
        label.classList.add("custom-label", "glow-text-anim");
        label.setAttribute("opacity", "1");
        label.textContent = name;
        layer.appendChild(label);
    });

    highlightNearestCircle(s1, "orange");
    highlightNearestCircle(s2, "red");
}




// ✅ 微調座標至最近線段上（吸附效果）
function adjustPointToNearestLine(pt, maxDistance = 200) {
    const svg = document.getElementById("mrtMap");
    if (!svg) return pt;

    let nearestPoint = pt;
    let minDist = maxDistance;

    svg.querySelectorAll("line").forEach(line => {
        const x1 = parseFloat(line.getAttribute("x1"));
        const y1 = parseFloat(line.getAttribute("y1"));
        const x2 = parseFloat(line.getAttribute("x2"));
        const y2 = parseFloat(line.getAttribute("y2"));
        if (isNaN(x1) || isNaN(y1) || isNaN(x2) || isNaN(y2)) return;

        const proj = getClosestPointOnSegment(pt.x, pt.y, x1, y1, x2, y2);
        const dx = pt.x - proj.x;
        const dy = pt.y - proj.y;
        const dist = Math.sqrt(dx * dx + dy * dy);

        if (dist < minDist) {
            minDist = dist;
            nearestPoint = proj;
        }
    });

    return nearestPoint;
}

// ✅ 計算某點在指定線段上的投影點
function getCoordsByStationName(name) {
    const svg = document.getElementById("mrtMap");
    if (!svg) return null;

    const text = Array.from(svg.querySelectorAll("text"))
        .find(el => el.textContent.trim() === name);

    if (!text) return null;

    const box = text.getBBox();
    return {
        x: box.x + box.width / 2,
        y: box.y + box.height / 2
    };
}

function highlightNearestCircle(pt, color = "yellow") {
    const svg = document.getElementById("mrtMap");
    if (!svg) return;

    let nearestCircle = null;
    let minDist = 9999;

    svg.querySelectorAll("circle").forEach(circle => {
        const cx = parseFloat(circle.getAttribute("cx"));
        const cy = parseFloat(circle.getAttribute("cy"));
        if (isNaN(cx) || isNaN(cy)) return;

        const dx = cx - pt.x;
        const dy = cy - pt.y;
        const dist = Math.sqrt(dx * dx + dy * dy);

        if (dist < minDist && dist < 30) {
            minDist = dist;
            nearestCircle = { cx, cy };
        }
    });

    if (nearestCircle) {
        const newCircle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
        newCircle.setAttribute("cx", nearestCircle.cx);
        newCircle.setAttribute("cy", nearestCircle.cy);
        newCircle.setAttribute("r", 10);
        newCircle.setAttribute("fill", color);
        newCircle.setAttribute("stroke", "black");
        newCircle.setAttribute("stroke-width", "2");
        newCircle.classList.add("custom-circle");

        // ✅ 不加到 <g>，直接加到 svg 最尾端，確保在最上層
        svg.appendChild(newCircle);
    }
}
function highlightRoute(startStation, endStation) {
  clearRoute();

  // 先移除全部站名的透明效果
  // 移除舊的高亮
  document.querySelectorAll('circle').forEach(c => c.classList.remove('highlight-circle'));

  // 對起訖站名找對應 circle
  const highlightCircleByStationName = (stationName) => {
    const circle = document.querySelector(`circle[id='station-${stationName}']`);
    if (circle) {
      circle.classList.add('highlight-circle');
    } else {
      console.warn(`找不到對應 circle: station-${stationName}`);
    }
  };

  highlightCircleByStationName(startStation);
  highlightCircleByStationName(endStation);

  drawRoute(startStation, endStation); // 畫線（可選）
}
// ✅ 加上站名特效
function applyStationEffect(stationName) {
    const svg = document.getElementById("mrtMap");
    if (!svg) return;

    const label = Array.from(svg.querySelectorAll("text.station-label"))
        .find(el => el.textContent.trim() === stationName);

    if (label) {
        label.classList.add("highlight-station");
    } else {
        console.warn(`❌ 找不到站名文字：${stationName}`);
    }
}

// ✅ 清除全部站名特效
function clearStationEffects() {
    document.querySelectorAll("text.station-label").forEach(el =>
        el.classList.remove("highlight-station"));
}

function previewProductImage(event) {
	  const file = event.target.files[0];
	  const preview = document.getElementById('previewImage');

	  if (!file || !file.type.startsWith("image/")) {
	    preview.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
	    return;
	  }

	  const reader = new FileReader();
	  reader.onload = function () {
	    preview.src = reader.result;
	  };
	  reader.readAsDataURL(file);
	}

	function submitNewProduct() {
	  const name = document.getElementById('productName').value.trim();
	  const desc = document.getElementById('productDescription').value.trim();
	  const priceValue = document.getElementById('productPrice').value.trim();
	  const stockValue = document.getElementById('productStock').value.trim();
	  const image = document.getElementById('imageInput').files[0];

	  let hasError = false;

	  // ✅ 商品名稱驗證
	  if (!name || !/^[\u4e00-\u9fa5a-zA-Z0-9\s]{1,20}$/.test(name)) {
	    document.getElementById('nameError').innerText =
	      window.i18n?.["form.name.invalid"] || "商品名稱僅限中英文、數字與空格，最多20字";
	    hasError = true;
	  } else {
	    document.getElementById('nameError').innerText = "";
	  }

	  // ✅ 商品敘述驗證
	  if (desc.length > 100) {
	    document.getElementById('priceError').innerText = ""; // 清空其他欄位錯誤提示
	    document.getElementById('stockError').innerText = "";
	    showMessage(window.i18n?.["form.description.tooLong"] || "❌ 商品敘述不得超過 100 字", false);
	    return;
	  }

	  // ✅ 價格驗證
	  if (!/^[1-9]\d*$/.test(priceValue)) {
	    document.getElementById('priceError').innerText =
	      window.i18n?.["form.price.required"] || "❌ 價格必須為正整數";
	    hasError = true;
	  } else {
	    document.getElementById('priceError').innerText = "";
	  }

	  // ✅ 存貨驗證
	  if (!/^\d+$/.test(stockValue)) {
	    document.getElementById('stockError').innerText =
	      window.i18n?.["form.stock.required"] || "❌ 存貨必須為 0 或正整數";
	    hasError = true;
	  } else {
	    document.getElementById('stockError').innerText = "";
	  }

	  if (hasError) return;

	  const price = parseInt(priceValue, 10);
	  const stock = parseInt(stockValue, 10);

	  const formData = new FormData();
	  formData.append("name", name);
	  formData.append("description", desc);
	  formData.append("price", price);
	  formData.append("stock", stock);
	  if (image) formData.append("image", image);

	  fetch("/api/products", {
	    method: "POST",
	    headers: {
	      [csrfHeaderName]: csrfToken
	    },
	    body: formData
	  })
	    .then(res => res.text())
	    .then(msg => {
	      showMessage(msg, true);
	      document.getElementById("addProductForm").reset();
	      document.getElementById("previewImage").src =
	        "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
	      loadContent("shop");
	    })
	    .catch(err => {
	      showMessage((window.i18n?.["form.create.fail"] || "❌ 新增商品失敗") + ": " + err.message, false);
	    });
	}



	function bindTooltipHandlers() {
	  const tooltips = document.querySelectorAll('[data-bs-toggle="tooltip"]');
	  tooltips.forEach(el => new bootstrap.Tooltip(el));
	}
	function deleteProduct(productId) {
	  const confirmMsg = window.i18n?.["product.confirm.delete"] || "確定要刪除這項商品嗎？";
	  if (!confirm(confirmMsg)) return;

	  fetch(`/api/products/${productId}`, {
	    method: 'DELETE',
	    headers: {
	      [csrfHeaderName]: csrfToken
	    }
	  })
	    .then(res => {
	      if (!res.ok) throw new Error(window.i18n?.["product.delete.fail"] || "刪除失敗");
	      return res.text();
	    })
	    .then(msg => {
	      showMessage(msg, true);
	      loadContent('shop');
	    })
	    .catch(err => showMessage(err.message, false));
	}
	window.deleteProduct = deleteProduct;

	//購物車
	function addToCart(button) {
	    const productId = button.getAttribute("data-id");
	    const name = button.getAttribute("data-name");
	    const price = parseFloat(button.getAttribute("data-price"));
	    const stock = parseInt(button.getAttribute("data-stock"));

	    const qtyInput = document.getElementById(`qty-${productId}`);
	    if (!qtyInput) {
	        showMessage(window.i18n?.["cart.error.noQtyInput"] || "❌ 找不到數量輸入欄位", false);
	        return;
	    }

	    const quantity = parseInt(qtyInput.value.trim(), 10);
	    if (isNaN(quantity) || quantity <= 0 || !Number.isInteger(quantity)) {
	        showMessage(window.i18n?.["cart.error.quantity"] || "❌ 數量必須為正整數", false);
	        return;
	    }

	    if (quantity > stock) {
	        const msg = window.i18n?.["cart.error.exceedStock"]?.replace("{max}", stock)
	                    || `❌ 數量超過庫存上限（最多 ${stock} 件）`;
	        showMessage(msg, false);
	        return;
	    }

	    // ✅ 檢查後端實際庫存
	    fetch(`/api/products/check-stock-by-id?id=${productId}&quantity=${quantity}`)
	        .then(res => {
	            if (!res.ok) return res.text().then(msg => { throw new Error(msg); });
	            return res.text();
	        })
	        .then(() => {
	            const existingItem = cart.find(item => item.productId == productId);
	            if (existingItem) {
	                const newQuantity = existingItem.quantity + quantity;
	                if (newQuantity > stock) {
	                    const msg = window.i18n?.["cart.error.totalExceedStock"]?.replace("{max}", stock)
	                                || `❌ 加入後超過庫存上限（最多 ${stock} 件）`;
	                    showMessage(msg, false);
	                    return;
	                }
	                existingItem.quantity = newQuantity;
	            } else {
	                cart.push({ productId: parseInt(productId), name, price, quantity });
	            }

	            const msg = window.i18n?.["cart.success.add"]
	                ?.replace("{name}", name).replace("{qty}", quantity)
	                || `✅ 已加入購物車：${name} x ${quantity}`;
	            showMessage(msg, true);
	            updateCartUI();
	        })
	        .catch(err => {
	            showMessage(err.message || (window.i18n?.["cart.error.general"] || "❌ 無法加入購物車"), false);
	        });
			localStorage.setItem('cart', JSON.stringify(cart));

	}







	function updateCartUI() {
	  const cartList = document.getElementById("cartItems");  // ✅ 改對 ID
	  const cartCount = document.getElementById("cartCount"); // 可選
	  const cartTotal = document.getElementById("cartTotal");

	  if (!cartList || !cartTotal) return;

	  cartList.innerHTML = "";

	  let total = 0;
	  cart.forEach(item => {
	    const li = document.createElement("li");
	    li.className = "list-group-item d-flex justify-content-between align-items-center";
	    li.innerHTML = `
	      ${item.name} × ${item.quantity}
	      <span>$${item.price * item.quantity}</span>
	    `;
	    cartList.appendChild(li);
	    total += item.price * item.quantity;
	  });

	  cartTotal.textContent = total.toFixed(0);
	  if (cartCount) cartCount.textContent = cart.length;
	}
	function clearCart() {
	  if (cart.length === 0) {
	    showMessage(window.i18n?.["cart.empty"] || "🛒 購物車是空的！", false);
	    return;
	  }

	  cart.length = 0;                         // 清空記憶體中購物車陣列
	  localStorage.removeItem('cart');         // ✅ 同步清除本地儲存
	  updateCartUI();                          // 更新畫面
	  showMessage(window.i18n?.["cart.clear.success"] || "🗑 購物車已清空", true);
	}

	// ✅ 必須綁成全域（讓 HTML onclick 可以使用）
	window.clearCart = clearCart;



//購物車結帳
function checkout() {
  if (cart.length === 0) {
    showMessage(window.i18n?.["cart.empty"] || "❗ 購物車是空的", false);
    return;
  }

  const summary = cart.map(item => `
    <div class="d-flex justify-content-between">
      <span>${item.name} x ${item.quantity}</span>
      <span class="text-danger">NT$${item.price * item.quantity}</span>
    </div>
  `).join('');

  const total = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);

  document.getElementById('checkoutSummary').innerHTML = `
    <p>${window.i18n?.["checkout.items"] || "您購買的商品如下："}</p>
    ${summary}
    <hr>
    <div class="d-flex justify-content-between fw-bold">
      <span>${window.i18n?.["checkout.total"] || "總金額："}</span>
      <span class="text-success">NT$${total}</span>
    </div>
  `;

  const modal = new bootstrap.Modal(document.getElementById('checkoutModal'));
  modal.show();
}

window.checkout = checkout; // 🔁 綁定為全域函式



function confirmCheckout() {
  const form = document.getElementById("checkoutForm");
  if (!form.checkValidity()) {
    form.classList.add("was-validated");
    return;
  }

  // 📝 取值
  const rawCardNumber = document.getElementById("cardNumber").value.trim();
  const cardNumber = rawCardNumber.replace(/\s+/g, '');
  const cardCVV = document.getElementById("cardCVV").value.trim();
  const email = document.getElementById("checkoutEmail")?.value.trim();
  const name = document.getElementById("checkoutName")?.value.trim();
  const phone = document.getElementById("checkoutPhone")?.value.trim();
  const pickupLocation = document.getElementById("pickupLocation")?.value.trim();

  // ✅ 前端驗證
  if (!/^\d{12,19}$/.test(cardNumber)) {
    showMessage("❌ 卡號格式錯誤，請輸入 12~19 位數字", false);
    return;
  }

  if (!/^\d{3}$/.test(cardCVV)) {
    showMessage("❌ 安全碼錯誤，請輸入 3 位數字", false);
    return;
  }

  if (!/^[\w.-]+@[a-zA-Z\d.-]+\.[a-zA-Z]{2,}$/.test(email)) {
    showMessage("❌ Email 格式錯誤", false);
    return;
  }

  // ✅ 即時庫存檢查（每一筆商品）
  const checks = cart.map(item =>
    fetch(`/api/products/check-stock-by-id?id=${item.productId}&quantity=${item.quantity}`)
      .then(async res => {
        const msg = await res.text();
        if (!res.ok) {
          throw new Error(`❌ 商品「${item.name}」庫存不足：${msg}`);
        }
        return msg;
      })
  );

  Promise.all(checks)
    .then(() => {
      // ✅ 封裝傳送資料
      const cartItems = {
        name,
        phone,
        email,
        pickupLocation,
        cardNumber,
        cardCVV,
        items: cart.map(item => ({
          productId: item.productId,
          quantity: item.quantity
        }))
      };

      return fetch("/api/orders", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          [csrfHeaderName]: csrfToken
        },
        body: JSON.stringify(cartItems)
      });
    })
    .then(async res => {
      const msg = await res.text();
      if (!res.ok) throw new Error(msg); // 拋出錯誤訊息
      return msg;
    })
    .then(msg => {
      showMessage(msg, true);
      clearCart();
      bootstrap.Modal.getInstance(document.getElementById("checkoutModal")).hide();
    })
    .catch(err => {
      showMessage(err.message || "❌ 結帳失敗", false);
    });
}



function bindCheckoutEvents() {
  const confirmBtn = document.getElementById("confirmCheckoutBtn");
  if (confirmBtn) {
    confirmBtn.addEventListener("click", confirmCheckout);
  } else {
    console.warn("⚠️ 找不到確認結帳按鈕 confirmCheckoutBtn");
  }
}
function loadShopFragment() {
  fetch('/fragment/shop')
    .then(response => response.text())
    .then(html => {
      document.getElementById('mainContent').innerHTML = html;
      bindCheckoutEvents(); // ⬅️ 載入後綁定按鈕事件
    });
}




function bindCardInputFormatter() {
  const cardInput = document.getElementById('cardNumber');
  if (cardInput) {
    cardInput.addEventListener('input', () => {
      let raw = cardInput.value.replace(/\D/g, ''); // 移除非數字
      if (raw.length > 19) raw = raw.slice(0, 19); // 最多 19 碼
      const formatted = raw.replace(/(.{4})/g, '$1 ').trim(); // 每 4 碼加空格
      cardInput.value = formatted;
    });
  }

  const cvvInput = document.getElementById('cardCVV');
  if (cvvInput) {
    cvvInput.addEventListener('input', () => {
      let val = cvvInput.value.replace(/\D/g, ''); // 只允許數字
      if (val.length > 3) val = val.slice(0, 3); // 最多 3 碼
      cvvInput.value = val;
    });
  }
}
//測試信
function sendTestMail() {
  fetch('/api/orders/test-mail', {
    method: 'GET',
    headers: {
      [csrfHeaderName]: csrfToken
    }
  })
    .then(res => {
      if (!res.ok) throw new Error("寄信失敗");
      return res.text();
    })
    .then(msg => showMessage(msg, true))
    .catch(err => showMessage("❌ " + err.message, false));
}
// ✅ 根據網址 hash 決定載入哪個區塊
document.addEventListener('DOMContentLoaded', () => {
  // 🛒 載入購物車內容
  const savedCart = localStorage.getItem('cart');
  if (savedCart) {
    cart.length = 0;
    cart.push(...JSON.parse(savedCart));
    updateCartUI();
  }

  // ✅ 綁定結帳按鈕（避免載入 shop 區塊後找不到按鈕）
  bindCheckoutEvents();

  // 🧭 根據網址 hash 載入對應區塊
  const hash = window.location.hash.replace('#', '');
  const validSections = ['price', 'map', 'shop', 'orders', 'welcome'];

  if (validSections.includes(hash)) {
    loadContent(hash);
  } else {
    loadContent('welcome');
  }
});


window.addEventListener('hashchange', () => {
  const hash = window.location.hash.replace('#', '');
  const validSections = ['price', 'map', 'shop', 'orders', 'welcome']; // ✅ 加上 'welcome'
  if (validSections.includes(hash)) {
    loadContent(hash);
  }
});
// ✅ 語系切換
function switchLang() {
  const currentLang = document.documentElement.lang;
  const newLang = currentLang === 'zh' ? 'en' : 'zh';
  const url = new URL(window.location.href);
  url.searchParams.set('lang', newLang);
  window.location.href = url.toString();
}

