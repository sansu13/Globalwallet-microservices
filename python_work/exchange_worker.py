import requests
import psycopg2

# API URL (free exchange rate API)
API_URL = "https://api.exchangerate-api.com/v4/latest/USD"

# DB connection
conn = psycopg2.connect(
    dbname="globalwallet",
    user="postgres",
    password="ewxg1528",
    host="postgres",
    port="5432"
)

cursor = conn.cursor()

def update_rates():
    response = requests.get(API_URL)
    data = response.json()

    rates = data["rates"]

    for currency, rate in rates.items():
        cursor.execute("""
            INSERT INTO exchange_rates (currency, rate)
            VALUES (%s, %s)
            ON CONFLICT (currency)
            DO UPDATE SET rate = EXCLUDED.rate
        """, (currency, rate))

    conn.commit()
    print("Exchange rates updated!")

if __name__ == "__main__":
    update_rates()