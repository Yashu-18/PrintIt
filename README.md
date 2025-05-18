# 🖨️ PrintIT

> A full-featured Android app for flex printing product discovery, customization, and ordering — built with Kotlin, Firebase, MVVM, and Razorpay integration.

---

## 📱 Description

PrintIT is a scalable Android application designed to streamline the flex printing experience for users. With real-time product listing updates, authentication (Email, Google, Facebook), filtering, and cart/wishlist management — all backed by Firebase — PrintIT offers a smooth and modern shopping experience.

---

## ✨ Features

- 🔐 Authentication  

  Sign up and login using:

  - Email & Password  

  - Google Account  

  - Facebook Account  

- 🛍️ Product Discovery  

  - Explore 100+ flex printing templates across multiple categories  

  - Advanced filtering by category for quick access  

- ❤️ Wishlist & 🛒 Cart  

  - Add and manage favorites or cart items with real-time updates  

  - Seamless Firebase-backed data syncing  

- 💳 Payment Integration  

  - Integrated with dummy Razorpay gateway for payment simulation  

- ⚡ Real-time Updates  

  - Firebase Realtime Database for dynamic content loading and state tracking  

- 🧠 Clean Architecture  

  - MVVM architecture for maintainability and scalability  

  - Kotlin Coroutines for efficient background processing  

---

## 🧪 Tech Stack

| Technology                     | Role |
|-------------------------------|------|
| Kotlin                        | Core application language |
| XML                           | UI Layouts |
| MVVM                          | Architecture pattern |
| Firebase Realtime Database    | Backend database for real-time updates |
| Firebase Authentication       | User sign-in/sign-up (Email, Google, Facebook) |
| Razorpay (dummy)              | Payment simulation |
| RecyclerView (Nested)         | For displaying multi-level categories |

---

## 📸 Screenshots

| Screen Name         | Screenshot                                   |
|---------------------|----------------------------------------------|
| Splash screen        | ![Splash]([https://via.placeholder.com/200x400?text=Login+Screen](https://private-user-images.githubusercontent.com/141062368/444884157-eaf815f6-d2fc-4f8a-a682-2887762b58d0.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc1Njk5NzYsIm5iZiI6MTc0NzU2OTY3NiwicGF0aCI6Ii8xNDEwNjIzNjgvNDQ0ODg0MTU3LWVhZjgxNWY2LWQyZmMtNGY4YS1hNjgyLTI4ODc3NjJiNThkMC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxOFQxMjAxMTZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0zZmZmNGM5NzM0YjNlZjY2NzM1MTFmNDU5NTYxNDkxNmMyNzQzMzUxMmQxNmQyODc0YTY4NGNjYzJmZjJhMjJlJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.2tmRmLR3OEKXLDoLDjR4gdFfkT5Hm3gD2-iM9Cmme2s)) |
| Authentication Screen         | ![Home]([https://via.placeholder.com/200x400?text=Home+Screen](https://private-user-images.githubusercontent.com/141062368/444884161-159b5bd9-08e3-46b0-a779-3ac2c498a29d.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc1Njk5NzYsIm5iZiI6MTc0NzU2OTY3NiwicGF0aCI6Ii8xNDEwNjIzNjgvNDQ0ODg0MTYxLTE1OWI1YmQ5LTA4ZTMtNDZiMC1hNzc5LTNhYzJjNDk4YTI5ZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxOFQxMjAxMTZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT04MGQ1MTIyNmNiYjUyY2MwMWJkYWZhN2IzYzQ1MTYzMjg2NmE0Y2IyMmVjMDAyNDhjY2QzMmQ4MDUxZTVhMDAwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.9crCfHFKPdgZYzkz_4Kt0bnojJbRTCA8J94xQAhEP8o)) |
| Product Listing     | ![Products]([https://via.placeholder.com/200x400?text=Product+Listing](https://private-user-images.githubusercontent.com/141062368/444884158-4bc276aa-028a-48c1-bcef-80c0ca11734d.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc1Njk0MjQsIm5iZiI6MTc0NzU2OTEyNCwicGF0aCI6Ii8xNDEwNjIzNjgvNDQ0ODg0MTU4LTRiYzI3NmFhLTAyOGEtNDhjMS1iY2VmLTgwYzBjYTExNzM0ZC5qcGc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxOFQxMTUyMDRaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0yMjRjNzQ5NDU5Yjc4Y2ViZmM5YzA4N2RmYzEyOWIwYmM1ZjVlOGVjYzIyYmI5YThmYTkzNTU5YjlmMmNjZDdiJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.QDXmC3aHvP9dKWx5KbTRN80AB6sxvU80nuAreAoaTK4)) |
| Product Details     | ![Details]([https://via.placeholder.com/200x400?text=Product+Details](https://private-user-images.githubusercontent.com/141062368/444884156-650719dd-1714-4a1e-ab59-1473835bdc06.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc1Njk0MjQsIm5iZiI6MTc0NzU2OTEyNCwicGF0aCI6Ii8xNDEwNjIzNjgvNDQ0ODg0MTU2LTY1MDcxOWRkLTE3MTQtNGExZS1hYjU5LTE0NzM4MzViZGMwNi5qcGc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxOFQxMTUyMDRaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0yYTExNzA4Nzc0NjZiODU4NTU5NzU1ODY3NjRjMjZlNDg4ZWM1MzNmNDNmZDY1OTYyOWRjNGMzY2NmNmFjZGZjJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.jT4DBmkklp0LLIQLOAaJnVFePokoJmpCPyvNiPlrypI)) |
| Cart            | ![Cart]([https://via.placeholder.com/200x400?text=Cart+and+Checkout](https://private-user-images.githubusercontent.com/141062368/444884162-6ee91ce1-aef4-490b-8acf-72e9731bb275.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc1Njk0MjQsIm5iZiI6MTc0NzU2OTEyNCwicGF0aCI6Ii8xNDEwNjIzNjgvNDQ0ODg0MTYyLTZlZTkxY2UxLWFlZjQtNDkwYi04YWNmLTcyZTk3MzFiYjI3NS5qcGc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxOFQxMTUyMDRaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kNjY3YzE5YzRhY2FkMjZkMGExYzY1YzdhZTVkNmRlMjIzZTMyODgzZjFhY2M4YThmOTRhOGYwNDc1Y2E1MjUxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.zUzTSiGHBUeabeRq1YdyZ8bQaK2PiZdKL8bzo9OHLe4)) |
| Wishlist            | ![Wishlist]([https://via.placeholder.com/200x400?text=Wishlist](https://private-user-images.githubusercontent.com/141062368/444884160-a73b63eb-bfe5-449f-aecd-24f2259f97cc.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc1Njk0MjQsIm5iZiI6MTc0NzU2OTEyNCwicGF0aCI6Ii8xNDEwNjIzNjgvNDQ0ODg0MTYwLWE3M2I2M2ViLWJmZTUtNDQ5Zi1hZWNkLTI0ZjIyNTlmOTdjYy5qcGc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxOFQxMTUyMDRaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1jNDNmMDczNzY2YzZmZjE2YjJkNzdkYjZhNjc4ZTJkZWQzOWViNTM5Zjg2OTNkNzk0OWQwNTNmNzYxM2FmZDZmJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.nkLVGf2HUHNzGNlSoyRAEsVz9il1tupktq-mZS5txmo)) |
| Payment Simulation  | ![Payment]([https://via.placeholder.com/200x400?text=Payment+Simulation](https://private-user-images.githubusercontent.com/141062368/444884159-360037d7-0a36-4ee9-b8b2-e650cf4eee9b.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc1Njk0MjQsIm5iZiI6MTc0NzU2OTEyNCwicGF0aCI6Ii8xNDEwNjIzNjgvNDQ0ODg0MTU5LTM2MDAzN2Q3LTBhMzYtNGVlOS1iOGIyLWU2NTBjZjRlZWU5Yi5qcGc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxOFQxMTUyMDRaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kNTVhODc0NWRjZDEyOGU2NzJmOTljNTRkYmE0NmI4MDhlZWEzNjhiNjNjNzFmNTExMDZhNWI5ZGIwNzViOTNkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.DxDSuQhCXophEgWQEYDiqI7_3RvryVgB8xbJxkJw7t4)) |

