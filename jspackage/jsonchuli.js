


const inputData = [
    {
        user_id: "1",
        channel: "A",
        time: "20250110 10:03:00",
        file_name: "file1.txt",
        link: "http://example.com/1",
        content_txt: "This is the first entry."
    },
    {
        user_id: "2",
        channel: "B",
        time: "20250111 11:04:00",
        file_name: "file2.txt",
        link: "http://example.com/2",
        content_txt: "This is the second entry."
    }
];

function transformData(input) {
    return input.map(item => ({
        title: item.time,
        content: [
            {
                ...item,
                content: item.file_name
            }
        ]
    }));
}

// 调用函数并打印结果
const updatedData = transformData(inputData);
console.log(JSON.stringify(updatedData, null, 2));
